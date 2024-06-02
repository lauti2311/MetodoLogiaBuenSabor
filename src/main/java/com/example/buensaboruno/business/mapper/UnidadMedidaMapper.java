package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.unidadMedida.UnidadMedidaFullDto;
import com.example.buensaboruno.domain.entities.UnidadMedida;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnidadMedidaMapper extends BaseMapper<UnidadMedida, UnidadMedidaFullDto> {
}
