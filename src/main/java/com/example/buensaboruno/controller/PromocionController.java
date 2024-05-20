package com.example.buensaboruno.controller;

import com.example.buensaboruno.domain.entities.Promocion;
import com.example.buensaboruno.service.PromocionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/promociones")
public class PromocionController extends BaseControllerImpl<Promocion, PromocionServiceImpl>{

    private PromocionServiceImpl service;
    public PromocionController(PromocionServiceImpl service) {
        super(service);
        this.service = service;
    }

}

