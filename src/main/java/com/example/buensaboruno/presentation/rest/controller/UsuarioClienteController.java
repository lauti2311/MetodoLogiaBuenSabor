package com.example.buensaboruno.presentation.rest.controller;

import com.example.buensaboruno.business.facade.imp.UsuarioClienteFacadeImp;
import com.example.buensaboruno.domain.dto.usuarioCliente.UsuarioClienteFullDto;
import com.example.buensaboruno.domain.entities.UsuarioCliente;
import com.example.buensaboruno.business.service.Imp.UsuarioClienteServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "usuarios")
public class UsuarioClienteController extends BaseControllerImpl<UsuarioCliente, UsuarioClienteFullDto, Long, UsuarioClienteFacadeImp> {

    public UsuarioClienteController(UsuarioClienteFacadeImp facade) {super (facade); }

}