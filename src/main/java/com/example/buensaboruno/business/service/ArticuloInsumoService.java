package com.example.buensaboruno.business.service;


import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, Long> {

    ResponseEntity<List<Map<String, Object>>> getAllImagesByInsumoId(Long id);
    ResponseEntity<String> uploadImages(MultipartFile[] files, Long id);
    ResponseEntity<String> deleteImage(String publicId, Long id);
}
