package com.example.buensaboruno.presentation.rest.controller;

import com.example.buensaboruno.business.facade.imp.ArticuloManufacturadoDetalleFacadeImp;
import com.example.buensaboruno.domain.dto.articuloManufacturadoDetalle.ArticuloManufacturadoDetalleFullDto;
import com.example.buensaboruno.domain.entities.ArticuloManufacturadoDetalle;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articuloManufacturadoDetalle")
@CrossOrigin("*")
public class ArticuloManufacturadoDetalleController extends BaseControllerImpl<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleFullDto, Long, ArticuloManufacturadoDetalleFacadeImp> {

    public ArticuloManufacturadoDetalleController(ArticuloManufacturadoDetalleFacadeImp facade) { super(facade); }
}
