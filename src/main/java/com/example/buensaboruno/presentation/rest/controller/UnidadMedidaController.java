package com.example.buensaboruno.presentation.rest.controller;

import com.example.buensaboruno.business.facade.imp.UnidadMedidaFacadeImp;
import com.example.buensaboruno.domain.dto.unidadMedida.UnidadMedidaFullDto;
import com.example.buensaboruno.domain.entities.UnidadMedida;
import com.example.buensaboruno.business.service.Imp.UnidadMedidaServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/unidadesmedida")
public class UnidadMedidaController extends BaseControllerImpl<UnidadMedida, UnidadMedidaFullDto, Long, UnidadMedidaFacadeImp> {
    public UnidadMedidaController(UnidadMedidaFacadeImp facade) {
        super(facade);
    }
}

