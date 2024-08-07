package com.example.buensaboruno.business.service.Imp;


import com.example.buensaboruno.business.mapper.ArticuloManufacturadoMapper;
import com.example.buensaboruno.business.service.ArticuloManufacturadoService;
import com.example.buensaboruno.business.service.Base.BaseServiceImpl;
import com.example.buensaboruno.business.service.CloudinaryService;
import com.example.buensaboruno.domain.dto.articuloManufacturado.ArticuloManufacturadoFullDto;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.domain.entities.ArticuloManufacturadoDetalle;
import com.example.buensaboruno.domain.entities.ImagenArticulo;
import com.example.buensaboruno.repositories.ArticuloInsumoRepository;
import com.example.buensaboruno.repositories.ArticuloManufacturadoDetalleRepository;
import com.example.buensaboruno.repositories.ArticuloManufacturadoRepository;
import com.example.buensaboruno.repositories.ImagenArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;


@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements ArticuloManufacturadoService {

    @Autowired
    ImagenArticuloRepository imagenArticuloRepository;
    @Autowired
    private CloudinaryService cloudinaryService; // Servicio para interactuar con Cloudinary
    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;
    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;
    @Autowired
    private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;
    @Autowired
    private ArticuloManufacturadoMapper articuloManufacturadoMapper;

    @Override
    public List<ArticuloManufacturadoFullDto> manufacturados(Long idSucursal) {
        List<ArticuloManufacturado> manufacturados = this.articuloManufacturadoRepository.manufacturados(idSucursal);
        return articuloManufacturadoMapper.manufacturadosToManufacturadoFullDtos(manufacturados);
    }
    @Override
    public ResponseEntity<List<Map<String, Object>>> getAllImagesByArticuloManufacturadoId(Long id) {
        try {
            // Consultar todas las imágenes desde la base de datos
            List<ImagenArticulo> images = baseRepository.getById(id).getImagenes().stream().toList();
            List<Map<String, Object>> imageList = new ArrayList<>();

            // Convertir cada imagen en un mapa de atributos para devolver como JSON
            for (ImagenArticulo image : images) {
                Map<String, Object> imageMap = new HashMap<>();
                imageMap.put("id", image.getId());
                imageMap.put("name", image.getName());
                imageMap.put("url", image.getUrl());
                imageList.add(imageMap);
            }

            // Devolver la lista de imágenes como ResponseEntity con estado OK (200)
            return ResponseEntity.ok(imageList);
        } catch (Exception e) {
            e.printStackTrace();
            // Devolver un error interno del servidor (500) si ocurre alguna excepción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }    }

    @Override
    public ResponseEntity<String> uploadImages(MultipartFile[] files, Long idArticuloManufacturado) {
        List<String> urls = new ArrayList<>();
        var articuloManufacturado = baseRepository.getById(idArticuloManufacturado);
        //por medio de un condicional limitamos la carga de imagenes a un maximo de 3 por aticulo
        //en caso de tratar de excer ese limite arroja un codigo 413 con el mensaje La cantidad maxima de imagenes es 3
        if(articuloManufacturado.getImagenes().size() >= 3)
            return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("La cantidad maxima de imagenes es 3");
        try {
            // Iterar sobre cada archivo recibido
            for (MultipartFile file : files) {
                // Verificar si el archivo está vacío
                if (file.isEmpty()) {
                    return ResponseEntity.badRequest().build();
                }

                // Crear una entidad Image y establecer su nombre y URL (subida a Cloudinary)
                ImagenArticulo image = new ImagenArticulo();
                image.setName(file.getOriginalFilename()); // Establecer el nombre del archivo original
                image.setUrl(cloudinaryService.uploadFile(file)); // Subir el archivo a Cloudinary y obtener la URL

                // Verificar si la URL de la imagen es nula (indicativo de fallo en la subida)
                if (image.getUrl() == null) {
                    return ResponseEntity.badRequest().build();
                }

                //Se asignan las imagenes al insumo
                articuloManufacturado.getImagenes().add(image);
                //Se guarda la imagen en la base de datos
                imagenArticuloRepository.save(image);
                // Agregar la URL de la imagen a la lista de URLs subidas
                urls.add(image.getUrl());
            }

            //se actualiza el insumo en la base de datos con las imagenes
            baseRepository.save(articuloManufacturado);

            // Convertir la lista de URLs a un objeto JSON y devolver como ResponseEntity con estado OK (200)
            return new ResponseEntity<>("{\"status\":\"OK\", \"urls\":" + urls + "}", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            // Devolver un error (400) si ocurre alguna excepción durante el proceso de subida
            return new ResponseEntity<>("{\"status\":\"ERROR\", \"message\":\"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }    }

    // Método para crear un articulo manufacturado con su detalle
    @Override
    public ArticuloManufacturado create(ArticuloManufacturado request) {
        Set<ArticuloManufacturadoDetalle> detalles = request.getArticuloManufacturadoDetalles(); // Obtener los detalles del articulo
        Set<ArticuloManufacturadoDetalle> detallesPersistidos = new HashSet<>(); // Crear un conjunto para almacenar los detalles persistidos

        if (detalles != null && !detalles.isEmpty()) {
            for (ArticuloManufacturadoDetalle detalle : detalles) { // Iterar sobre cada detalle
                ArticuloInsumo articuloInsumo = detalle.getArticuloInsumo();
                if (articuloInsumo == null || articuloInsumo.getId() == null) {
                    throw new RuntimeException("Id de articulo detalle nulo");
                }
                articuloInsumo = articuloInsumoRepository.findById(detalle.getArticuloInsumo().getId()) // Buscar el articulo por ID
                        .orElseThrow(() -> new RuntimeException("No existe el articulo con id " + detalle.getArticuloInsumo().getId() ));// Lanzar una excepción si no se encuentra
                detalle.setArticuloInsumo(articuloInsumo);
                ArticuloManufacturadoDetalle savedDetalle = articuloManufacturadoDetalleRepository.save(detalle); // Guardar el detalle en la base de datos
                detallesPersistidos.add(savedDetalle);
            }
            request.setArticuloManufacturadoDetalles(detallesPersistidos);
        } else {
            throw new IllegalArgumentException("Debe contener un detalle");
        }

        return articuloManufacturadoRepository.save(request);
    }
    @Override
    public ArticuloManufacturado update(ArticuloManufacturado request, Long id) {
        Optional<ArticuloManufacturado> optionalArticulo = articuloManufacturadoRepository.findById(id);
        if (optionalArticulo.isEmpty()) {
            throw new RuntimeException("No existe el articulo manufacturado con id " + id);
        }

        ArticuloManufacturado articuloManufacturado = optionalArticulo.get();
        articuloManufacturado.setDenominacion(request.getDenominacion());
        articuloManufacturado.setPrecioVenta(request.getPrecioVenta());
        articuloManufacturado.setDescripcion(request.getDescripcion());
        articuloManufacturado.setTiempoEstimadoMinutos(request.getTiempoEstimadoMinutos());
        articuloManufacturado.setPreparacion(request.getPreparacion());
        articuloManufacturado.setCategoria(request.getCategoria());
        articuloManufacturado.setUnidadMedida(request.getUnidadMedida());

        Set<ArticuloManufacturadoDetalle> detalles = request.getArticuloManufacturadoDetalles();
        if (detalles != null && !detalles.isEmpty()) {
            Set<ArticuloManufacturadoDetalle> detallesPersistidos = new HashSet<>();
            for (ArticuloManufacturadoDetalle detalle : detalles) {
                ArticuloInsumo articuloInsumo = detalle.getArticuloInsumo();
                if (articuloInsumo == null || articuloInsumo.getId() == null) {
                    throw new RuntimeException("Id de articulo detalle nulo");
                }
                articuloInsumo = articuloInsumoRepository.findById(detalle.getArticuloInsumo().getId())
                        .orElseThrow(() -> new RuntimeException("No existe el articulo con id " + detalle.getArticuloInsumo().getId()));
                detalle.setArticuloInsumo(articuloInsumo);
                ArticuloManufacturadoDetalle savedDetalle = articuloManufacturadoDetalleRepository.save(detalle);
                detallesPersistidos.add(savedDetalle);
            }
            articuloManufacturado.setArticuloManufacturadoDetalles(detallesPersistidos);
        }

        return articuloManufacturadoRepository.save(articuloManufacturado);
    }
    @Override
    public ResponseEntity<String> deleteImage(String publicId, Long id) {
        try {
            // Eliminar la imagen de la base de datos usando su identificador
            imagenArticuloRepository.deleteById(id);

            // Llamar al servicio de Cloudinary para eliminar la imagen por su publicId
            return cloudinaryService.deleteImage(publicId, id);

        } catch (Exception e) {
            e.printStackTrace();
            // Devolver un error (400) si ocurre alguna excepción durante la eliminación
            return new ResponseEntity<>("{\"status\":\"ERROR\", \"message\":\"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
    }

}
