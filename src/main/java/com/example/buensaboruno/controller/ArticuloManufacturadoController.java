package com.example.buensaboruno.controller;


import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.service.ArticuloManufacturadoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "manufacturados")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoServiceImpl>{

    protected final ArticuloManufacturadoServiceImpl service;
    public ArticuloManufacturadoController(ArticuloManufacturadoServiceImpl service ) {
        super(service);
        this.service = service;
    }


}

