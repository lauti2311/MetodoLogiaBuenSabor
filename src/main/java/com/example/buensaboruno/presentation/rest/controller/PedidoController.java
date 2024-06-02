package com.example.buensaboruno.presentation.rest.controller;


import com.example.buensaboruno.business.facade.imp.PedidoFacadeImp;
import com.example.buensaboruno.domain.dto.pedido.PedidoFullDto;
import com.example.buensaboruno.domain.entities.Pedido;
import com.example.buensaboruno.business.service.Imp.PedidoServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoFullDto, Long, PedidoFacadeImp> {

    public PedidoController(PedidoFacadeImp facade) {super (facade); }

}
