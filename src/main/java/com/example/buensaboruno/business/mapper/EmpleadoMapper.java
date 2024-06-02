package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.empleado.EmpleadoFullDto;
import com.example.buensaboruno.domain.entities.Empleado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper extends BaseMapper<Empleado, EmpleadoFullDto>{
}
