package com.example.buensaboruno.business.facade.imp;


import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.FacturaFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.business.service.FacturaService;
import com.example.buensaboruno.domain.dto.factura.FacturaFullDto;
import com.example.buensaboruno.domain.entities.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaFacadeImp extends BaseFacadeImp<Factura, FacturaFullDto, Long> implements FacturaFacade {

    @Autowired
    private FacturaService facturaService;
    public FacturaFacadeImp(BaseService<Factura, Long> baseService, BaseMapper<Factura, FacturaFullDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Override
    public Factura crearFactura(Long pedidoId) {
        return facturaService.crearFactura(pedidoId);
    }
}
