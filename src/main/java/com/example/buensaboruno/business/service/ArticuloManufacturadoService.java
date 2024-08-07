package com.example.buensaboruno.business.service;


import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.dto.articuloManufacturado.ArticuloManufacturadoFullDto;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, Long> {
    ResponseEntity<List<Map<String, Object>>> getAllImagesByArticuloManufacturadoId(Long id);
    // Método para subir imágenes al sistema
    ResponseEntity<String> uploadImages(MultipartFile[] files, Long id);
    // Método para eliminar una imagen por su identificador público y Long
    ResponseEntity<String> deleteImage(String publicId, Long id);
    List<ArticuloManufacturadoFullDto> manufacturados(Long idSucursal);
}
