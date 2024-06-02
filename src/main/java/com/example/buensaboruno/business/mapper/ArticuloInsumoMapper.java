package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.articuloInsumo.ArticuloInsumoFullDto;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import org.mapstruct.Mapper;

@Mapper(componentModel =  "spring", uses = LocalidadMapper.class)
public interface ArticuloInsumoMapper extends BaseMapper<ArticuloInsumo, ArticuloInsumoFullDto> {
}
