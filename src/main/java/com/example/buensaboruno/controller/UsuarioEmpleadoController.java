package com.example.buensaboruno.controller;


import com.example.buensaboruno.domain.entities.UsuarioEmpleado;
import com.example.buensaboruno.service.UsuarioEmpleadoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/UsuarioEmpleado")
public class UsuarioEmpleadoController extends BaseControllerImpl<UsuarioEmpleado, UsuarioEmpleadoServiceImpl>{

    private UsuarioEmpleadoServiceImpl service;
    public UsuarioEmpleadoController(UsuarioEmpleadoServiceImpl service) {
        super(service);
    }
}

