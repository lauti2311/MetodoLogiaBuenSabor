package com.example.buensaboruno.presentation.rest.controller;

import com.example.buensaboruno.business.service.Imp.MercadoPagoService;
import com.example.buensaboruno.domain.dto.pedido.PedidoFullDto;
import com.example.buensaboruno.domain.entities.PreferenceMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mercado_pago")
public class MercadoPagoController {

    @Autowired
    private MercadoPagoService mercadoPagoService;

    @PostMapping("/create_preference")
    public PreferenceMP getPreferenciaIdMercadoPago(@RequestBody PedidoFullDto pedido) {
        return mercadoPagoService.createPreference(pedido);
    }
}
