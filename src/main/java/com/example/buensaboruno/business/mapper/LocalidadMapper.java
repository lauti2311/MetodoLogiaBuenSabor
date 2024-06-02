package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.localidad.LocalidadFullDto;
import com.example.buensaboruno.domain.entities.Localidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocalidadMapper extends BaseMapper<Localidad, LocalidadFullDto> {
}
