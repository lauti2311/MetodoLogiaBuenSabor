package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.usuarioCliente.UsuarioClienteFullDto;
import com.example.buensaboruno.domain.entities.UsuarioCliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioClienteMapper extends BaseMapper<UsuarioCliente, UsuarioClienteFullDto>{
}
