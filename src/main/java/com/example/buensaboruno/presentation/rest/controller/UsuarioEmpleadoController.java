package com.example.buensaboruno.presentation.rest.controller;


import com.example.buensaboruno.business.facade.imp.UsuarioEmpleadoFacadeImp;
import com.example.buensaboruno.domain.dto.usuarioEmpleado.UsuarioEmpleadoFullDto;
import com.example.buensaboruno.domain.entities.UsuarioEmpleado;
import com.example.buensaboruno.business.service.Imp.UsuarioEmpleadoServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/usuarioEmpleado")
public class UsuarioEmpleadoController extends BaseControllerImpl<UsuarioEmpleado, UsuarioEmpleadoFullDto, Long, UsuarioEmpleadoFacadeImp> {
    public UsuarioEmpleadoController(UsuarioEmpleadoFacadeImp facade) {super(facade); }

}

