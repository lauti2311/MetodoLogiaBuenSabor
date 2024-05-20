package com.example.buensaboruno.service;

import com.example.buensaboruno.domain.entities.Pedido;
import com.example.buensaboruno.repositories.PedidoRepository;
import org.springframework.stereotype.Service;


@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    private PedidoRepository pedidoRepository;
    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        super(pedidoRepository);
        this.pedidoRepository = pedidoRepository;
    }
}
