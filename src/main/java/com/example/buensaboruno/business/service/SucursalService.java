package com.example.buensaboruno.business.service;


import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.dto.sucursal.SucursalFullDto;
import com.example.buensaboruno.domain.entities.Sucursal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface SucursalService extends BaseService<Sucursal, Long> {
    Sucursal guardarSucursal(Sucursal sucursal);
    Sucursal actualizarSucursal(Long id,Sucursal sucursal);

    ResponseEntity<List<Map<String, Object>>> getAllImagesBySucursalId(Long id);

    ResponseEntity<String> uploadImages(MultipartFile[] files, Long id);

    ResponseEntity<String> deleteImage(String publicId, Long id);

    List<SucursalFullDto> sucursalEmpresa(Long idEmpresa);

}
