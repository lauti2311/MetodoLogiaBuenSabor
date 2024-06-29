package com.example.buensaboruno.business.facade;


import com.example.buensaboruno.business.facade.Base.BaseFacade;
import com.example.buensaboruno.domain.dto.articuloManufacturado.ArticuloManufacturadoFullDto;
import com.example.buensaboruno.domain.dto.articuloManufacturadoDetalle.ArticuloManufacturadoDetalleFullDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ArticuloManufacturadoDetalleFacade extends BaseFacade<ArticuloManufacturadoDetalleFullDto, Long> {

    ResponseEntity<List<Map<String, Object>>> getAllImagesByArticuloManufacturadoId(Long id);
    // Método para subir imágenes al sistema
    ResponseEntity<String> uploadImages(MultipartFile[] files, Long id);
    // Método para eliminar una imagen por su identificador público y UUID
    ResponseEntity<String> deleteImage(String publicId, Long id);
    List<ArticuloManufacturadoFullDto> manufacturados(Long idSucursal);
}
