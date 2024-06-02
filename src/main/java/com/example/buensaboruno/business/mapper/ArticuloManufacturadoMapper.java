package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.articuloManufacturado.ArticuloManufacturadoFullDto;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ArticuloManufacturadoMapper extends BaseMapper<ArticuloManufacturado, ArticuloManufacturadoFullDto> {
}
