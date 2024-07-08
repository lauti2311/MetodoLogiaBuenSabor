package com.example.buensaboruno.business.facade;


import com.example.buensaboruno.business.facade.Base.BaseFacade;
import com.example.buensaboruno.domain.dto.factura.FacturaFullDto;
import com.example.buensaboruno.domain.entities.Factura;

public interface FacturaFacade extends BaseFacade<FacturaFullDto, Long> {
    Factura crearFactura(Long pedidoId);
}
