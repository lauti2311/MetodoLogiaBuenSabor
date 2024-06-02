package com.example.buensaboruno.presentation.rest.controller;



import com.example.buensaboruno.business.facade.imp.DomicilioFacadeImp;
import com.example.buensaboruno.domain.dto.domicilio.DomicilioFullDto;
import com.example.buensaboruno.domain.entities.Domicilio;
import com.example.buensaboruno.business.service.Imp.DomicilioServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/domicilios")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioFullDto,Long, DomicilioFacadeImp> {
    public DomicilioController(DomicilioFacadeImp facade) {
        super(facade);
    }
}

