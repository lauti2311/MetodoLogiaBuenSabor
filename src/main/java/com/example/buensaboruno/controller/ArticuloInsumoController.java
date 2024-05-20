package com.example.buensaboruno.controller;

import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.service.ArticuloInsumoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/insumos")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl>{
    protected final ArticuloInsumoServiceImpl service;
    public ArticuloInsumoController(ArticuloInsumoServiceImpl service) {
        super(service);
        this.service = service;
    }

}