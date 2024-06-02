package com.example.buensaboruno.presentation.rest.controller;


import com.example.buensaboruno.business.facade.imp.FacturaFacadeImp;
import com.example.buensaboruno.domain.dto.factura.FacturaFullDto;
import com.example.buensaboruno.domain.entities.Factura;
import com.example.buensaboruno.business.service.Imp.FacturaServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/facturas")
public class FacturaController extends BaseControllerImpl<Factura, FacturaFullDto, Long, FacturaFacadeImp> {

    public FacturaController(FacturaFacadeImp facade) {super (facade); }

}
