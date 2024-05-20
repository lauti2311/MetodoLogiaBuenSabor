package com.example.buensaboruno.controller;


import com.example.buensaboruno.domain.entities.Factura;
import com.example.buensaboruno.service.FacturaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/facturas")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl>{

    private FacturaServiceImpl service;
    public FacturaController(FacturaServiceImpl service) {
        super(service);
    }
}

