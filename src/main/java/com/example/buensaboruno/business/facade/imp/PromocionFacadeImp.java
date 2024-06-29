package com.example.buensaboruno.business.facade.imp;


import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.PromocionFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.business.service.PromocionService;
import com.example.buensaboruno.domain.dto.promocion.PromocionFullDto;
import com.example.buensaboruno.domain.entities.Promocion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class PromocionFacadeImp extends BaseFacadeImp<Promocion, PromocionFullDto, Long> implements PromocionFacade {
    public PromocionFacadeImp(BaseService<Promocion, Long> baseService, BaseMapper<Promocion, PromocionFullDto> baseMapper) {
        super(baseService, baseMapper);
    }
    @Autowired
    PromocionService promocionService;
    @Override
    public ResponseEntity<List<Map<String, Object>>> getAllImagesByPromocionId(Long id) {
        return promocionService.getAllImagesByPromocionId(id);
    }

    @Override
    public ResponseEntity<String> uploadImages(MultipartFile[] files, Long id) {
        return promocionService.uploadImages(files,id);
    }

    @Override
    public ResponseEntity<String> deleteImage(String publicId, Long id) {
        return promocionService.deleteImage(publicId, id);
    }
    public List<PromocionFullDto> promocionSucursal(Long idSucursal) {
        return this.promocionService.promocionSucursal(idSucursal);
    }
}
