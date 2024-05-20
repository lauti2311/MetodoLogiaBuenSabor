package com.example.buensaboruno.controller;


import com.example.buensaboruno.domain.entities.Pais;
import com.example.buensaboruno.service.PaisServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/paises")
public class PaisController extends BaseControllerImpl<Pais, PaisServiceImpl>{

    private PaisServiceImpl service;
    public PaisController(PaisServiceImpl service) {
        super(service);
    }
}

