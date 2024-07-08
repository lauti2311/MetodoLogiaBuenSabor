package com.example.buensaboruno.business.facade.imp;

import com.example.buensaboruno.business.facade.ArticuloManufacturadoDetalleFacade;
import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.ArticuloManufacturadoService;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.dto.articuloManufacturado.ArticuloManufacturadoFullDto;
import com.example.buensaboruno.domain.dto.articuloManufacturadoDetalle.ArticuloManufacturadoDetalleFullDto;
import com.example.buensaboruno.domain.entities.ArticuloManufacturadoDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ArticuloManufacturadoDetalleFacadeImp extends BaseFacadeImp<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleFullDto, Long> implements ArticuloManufacturadoDetalleFacade {
    public ArticuloManufacturadoDetalleFacadeImp(BaseService<ArticuloManufacturadoDetalle,Long> baseService, BaseMapper<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleFullDto> baseMapper){
        super(baseService, baseMapper);
    }
    @Autowired
    ArticuloManufacturadoService articuloManufacturadoService;
    @Override
    public List<ArticuloManufacturadoFullDto> manufacturados(Long idSucursal) {
        return this.articuloManufacturadoService.manufacturados(idSucursal);
    }
    @Override
    public ResponseEntity<List<Map<String, Object>>> getAllImagesByArticuloManufacturadoId(Long id) {
        return articuloManufacturadoService.getAllImagesByArticuloManufacturadoId(id);
    }

    @Override
    public ResponseEntity<String> uploadImages(MultipartFile[] files, Long id) {
        return articuloManufacturadoService.uploadImages(files,id);
    }

    @Override
    public ResponseEntity<String> deleteImage(String publicId, Long id) {
        return articuloManufacturadoService.deleteImage(publicId, id);
    }
}
