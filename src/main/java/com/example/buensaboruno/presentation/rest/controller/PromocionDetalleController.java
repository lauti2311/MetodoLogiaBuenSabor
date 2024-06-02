package com.example.buensaboruno.presentation.rest.controller;

import com.example.buensaboruno.business.facade.imp.PromocionDetalleFacadeImp;
import com.example.buensaboruno.domain.dto.promocionDetalle.PromocionDetalleFullDto;
import com.example.buensaboruno.domain.entities.PromocionDetalle;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/promocionDetalle")
public class PromocionDetalleController extends BaseControllerImpl<PromocionDetalle, PromocionDetalleFullDto, Long, PromocionDetalleFacadeImp> {

    public PromocionDetalleController(PromocionDetalleFacadeImp facade) {super(facade);}

}
