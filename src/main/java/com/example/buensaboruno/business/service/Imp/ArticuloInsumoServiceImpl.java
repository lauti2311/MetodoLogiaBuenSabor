package com.example.buensaboruno.business.service.Imp;


import com.example.buensaboruno.business.mapper.ArticuloInsumoMapper;
import com.example.buensaboruno.business.service.ArticuloInsumoService;
import com.example.buensaboruno.business.service.Base.BaseServiceImpl;
import com.example.buensaboruno.business.service.CloudinaryService;
import com.example.buensaboruno.domain.dto.articuloInsumo.ArticuloInsumoFullDto;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.domain.entities.ImagenArticulo;
import com.example.buensaboruno.repositories.ArticuloInsumoRepository;
import com.example.buensaboruno.repositories.ImagenArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoService {

    @Autowired
    ImagenArticuloRepository imagenArticuloRepository;

    @Autowired
    private CloudinaryService cloudinaryService; // Servicio para interactuar con Cloudinary
    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;
    @Autowired
    private ArticuloInsumoMapper articuloInsumoMapper;

    @Override
    public ArticuloInsumo update(ArticuloInsumo updatedArticulo, Long articuloId) {
        ArticuloInsumo existingArticulo = articuloInsumoRepository.findById(articuloId)
                .orElseThrow(() -> new RuntimeException("Articulo not found"));

        // Actualizar los campos básicos del artículo
        existingArticulo.setDenominacion(updatedArticulo.getDenominacion());
        existingArticulo.setEsParaElaborar(updatedArticulo.getEsParaElaborar());
        existingArticulo.setPrecioCompra(updatedArticulo.getPrecioCompra());
        existingArticulo.setPrecioVenta(updatedArticulo.getPrecioVenta());
        existingArticulo.setUnidadMedida(updatedArticulo.getUnidadMedida());
        existingArticulo.setCategoria(updatedArticulo.getCategoria());
        existingArticulo.setSucursal(updatedArticulo.getSucursal());
        existingArticulo.setStockActual(updatedArticulo.getStockActual());
        existingArticulo.setStockMinimo(updatedArticulo.getStockMinimo());
        existingArticulo.setStockMaximo(updatedArticulo.getStockMaximo());
        return articuloInsumoRepository.save(existingArticulo);
    }

    @Override
    public List<ArticuloInsumoFullDto> insumosParaElaborar(Long idSucursal) {
        List<ArticuloInsumo> insumos = this.articuloInsumoRepository.insumosParaElaborar(idSucursal);
        return articuloInsumoMapper.insumosToInsumoFullDtos(insumos);
    }
    @Override
    public List<ArticuloInsumoFullDto> insumos(Long idSucursal) {
        List<ArticuloInsumo> insumos = this.articuloInsumoRepository.insumos(idSucursal);
        return articuloInsumoMapper.insumosToInsumoFullDtos(insumos);
    }
    @Override
    public ResponseEntity<Number> descontarStock(ArticuloInsumo articuloInsumo, Integer cantidad) {
        try {
            // Obtener el insumo del artículo
            ArticuloInsumo insumo = articuloInsumo;

            // Descontar la cantidad del stock actual
            int stockDescontado = insumo.getStockActual() - cantidad;

            // Asignar el nuevo stock al insumo
            insumo.setStockActual(stockDescontado);

            // Retornar el stock actualizado
            return ResponseEntity.ok(stockDescontado);
        } catch (Exception e) {
            // En caso de error, imprimir la excepción y retornar un mensaje de error
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @Override
    public ResponseEntity<List<Map<String, Object>>> getAllImagesByInsumoId(Long id) {
        try {
            // Consultar todas las imágenes desde la base de datos
            List<ImagenArticulo> images = baseRepository.getById(id)
                    .getImagenes()
                    .stream()
                    // Filtrar las imágenes no eliminadas
                    .filter(image -> !image.isEliminado())
                    .toList();
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
        }
    }

    @Override
    public ResponseEntity<String> uploadImages(MultipartFile[] files, Long idArticuloInsumo) {
        List<String> urls = new ArrayList<>();
        var insumo = baseRepository.getById(idArticuloInsumo);
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
                insumo.getImagenes().add(image);
                //Se guarda la imagen en la base de datos
                imagenArticuloRepository.save(image);
                // Agregar la URL de la imagen a la lista de URLs subidas
                urls.add(image.getUrl());
            }

            //se actualiza el insumo en la base de datos con las imagenes
            baseRepository.save(insumo);

            // Convertir la lista de URLs a un objeto JSON y devolver como ResponseEntity con estado OK (200)
            return new ResponseEntity<>("{\"status\":\"OK\", \"urls\":" + urls + "}", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            // Devolver un error (400) si ocurre alguna excepción durante el proceso de subida
            return new ResponseEntity<>("{\"status\":\"ERROR\", \"message\":\"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteImage(String publicId, Long id) {
        try {
            // Eliminar la imagen de la base de datos usando su identificador
            imagenArticuloRepository.deleteById(id);

            // Llamar al servicio de Cloudinary para eliminar la imagen por su publicId
            ResponseEntity<String> cloudinaryResponse = cloudinaryService.deleteImage(publicId, id);

            // Retornar la respuesta del servicio de Cloudinary junto con la respuesta del repositorio
            return new ResponseEntity<>("{\"status\":\"SUCCESS\", \"message\":\"Imagen eliminada exitosamente.\"}", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // Devolver un error (400) si ocurre alguna excepción durante la eliminación
            return new ResponseEntity<>("{\"status\":\"ERROR\", \"message\":\"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
    }
}
