package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.usuarioEmpleado.UsuarioEmpleadoFullDto;
import com.example.buensaboruno.domain.entities.UsuarioEmpleado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioEmpleadoMapper extends BaseMapper<UsuarioEmpleado, UsuarioEmpleadoFullDto>{
}
