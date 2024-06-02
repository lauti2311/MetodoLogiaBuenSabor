package com.example.buensaboruno.presentation.rest.controller;


import com.example.buensaboruno.business.facade.imp.PaisFacadeImp;
import com.example.buensaboruno.domain.dto.pais.PaisFullDto;
import com.example.buensaboruno.domain.entities.Pais;
import com.example.buensaboruno.business.service.Imp.PaisServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/paises")
public class PaisController extends BaseControllerImpl<Pais, PaisFullDto,Long, PaisFacadeImp> {

    public PaisController(PaisFacadeImp facade) {
        super(facade);
    }
}