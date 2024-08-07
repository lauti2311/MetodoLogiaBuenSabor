package com.example.buensaboruno.business.facade;


import com.example.buensaboruno.business.facade.Base.BaseFacade;
import com.example.buensaboruno.domain.dto.articuloInsumo.ArticuloInsumoFullDto;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ArticuloInsumoFacade extends BaseFacade<ArticuloInsumoFullDto,Long> {
    //Imagenes
    // Método para obtener todas las imágenes almacenadas
    ResponseEntity<List<Map<String, Object>>> getAllImagesByInsumoId(Long id);
    // Método para subir imágenes al sistema
    ResponseEntity<String> uploadImages(MultipartFile[] files, Long id);
    // Método para eliminar una imagen por su identificador público y UUID
    ResponseEntity<String> deleteImage(String publicId, Long id);
    ResponseEntity<Number> descontarStock(ArticuloInsumo articuloInsumo, Integer cantidad);
    List<ArticuloInsumoFullDto> insumosParaElaborar(Long idSucursal);
    List<ArticuloInsumoFullDto> insumos(Long idSucursal);
}
