package com.example.buensaboruno.presentation.rest.controller;


import com.example.buensaboruno.business.facade.imp.DetallePedidoFacadeImp;
import com.example.buensaboruno.domain.dto.detallePedido.DetallePedidoFullDto;
import com.example.buensaboruno.domain.entities.DetallePedido;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detallePedido")
@CrossOrigin("*")
public class DetallePedidoController extends BaseControllerImpl<DetallePedido, DetallePedidoFullDto, Long, DetallePedidoFacadeImp> {

    public DetallePedidoController(DetallePedidoFacadeImp facade) {super (facade); }
}
