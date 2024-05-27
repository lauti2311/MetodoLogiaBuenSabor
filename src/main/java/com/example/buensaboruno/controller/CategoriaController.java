package com.example.buensaboruno.controller;


import com.example.buensaboruno.domain.entities.Categoria;
import com.example.buensaboruno.service.CategoriaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "categorias")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaServiceImpl>{

    private final CategoriaServiceImpl service;
    public CategoriaController(CategoriaServiceImpl service) {
        super(service);
        this.service = service;
    }


}

