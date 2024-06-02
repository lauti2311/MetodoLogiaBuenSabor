package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.cliente.ClienteFullDto;
import com.example.buensaboruno.domain.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ClienteMapper extends BaseMapper<Cliente, ClienteFullDto>{
}
