package com.example.buensaboruno.presentation.rest.controller;


import com.example.buensaboruno.business.facade.imp.ClienteFacadeImp;
import com.example.buensaboruno.domain.dto.cliente.ClienteFullDto;
import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.business.service.Imp.ClienteServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteFullDto, Long, ClienteFacadeImp> {

    public ClienteController(ClienteFacadeImp facade) {super (facade); }
}

