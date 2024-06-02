package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.detallePedido.DetallePedidoFullDto;
import com.example.buensaboruno.domain.entities.DetallePedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface DetallePedidoMapper extends BaseMapper<DetallePedido, DetallePedidoFullDto>{
}
