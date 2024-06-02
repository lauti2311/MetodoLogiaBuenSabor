package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.pedido.PedidoFullDto;
import com.example.buensaboruno.domain.entities.Pedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper extends BaseMapper<Pedido, PedidoFullDto>{
}
