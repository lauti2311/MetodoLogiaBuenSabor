package com.example.buensaboruno.business.facade;


import com.example.buensaboruno.business.facade.Base.BaseFacade;
import com.example.buensaboruno.domain.dto.sucursal.SucursalFullDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface Sucursalfacade extends BaseFacade<SucursalFullDto, Long> {
    SucursalFullDto createSucursal(SucursalFullDto dto);
    SucursalFullDto updateSucursal(Long id, SucursalFullDto dto);
    //Imagenes
    // Método para obtener todas las imágenes almacenadas
    ResponseEntity<List<Map<String, Object>>> getAllImagesBySucursalId(Long id);
    // Método para subir imágenes al sistema
    ResponseEntity<String> uploadImages(MultipartFile[] files, Long id);
    // Método para eliminar una imagen por su identificador público y UUID
    ResponseEntity<String> deleteImage(String publicId, Long id);

    List<SucursalFullDto> sucursalEmpresa(Long idEmpresa);

}
