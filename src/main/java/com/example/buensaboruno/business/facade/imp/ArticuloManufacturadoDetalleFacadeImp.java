package com.example.buensaboruno.business.facade.imp;

import com.example.buensaboruno.business.facade.ArticuloManufacturadoDetalleFacade;
import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.dto.articuloManufacturadoDetalle.ArticuloManufacturadoDetalleFullDto;
import com.example.buensaboruno.domain.entities.ArticuloManufacturadoDetalle;
import org.springframework.stereotype.Service;

@Service
public class ArticuloManufacturadoDetalleFacadeImp extends BaseFacadeImp<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleFullDto, Long> implements ArticuloManufacturadoDetalleFacade {
    public ArticuloManufacturadoDetalleFacadeImp(BaseService<ArticuloManufacturadoDetalle,Long> baseService, BaseMapper<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleFullDto> baseMapper){
        super(baseService, baseMapper);
    }

}
