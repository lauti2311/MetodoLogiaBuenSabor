package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.pedido.PedidoFullDto;
import com.example.buensaboruno.domain.entities.Pedido;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = { DomicilioMapper.class, SucursalMapper.class, DetallePedidoMapper.class })
public interface PedidoMapper extends BaseMapper<Pedido, PedidoFullDto>{
    List<PedidoFullDto> pedidosToPedidoFullDtos(List<Pedido> pedidos);
}
