package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.business.service.CategoriaService;
import com.example.buensaboruno.domain.dto.articulo.ArticuloDto;
import com.example.buensaboruno.domain.entities.Articulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CategoriaService.class, CategoriaMapper.class})
public interface ArticuloMapper extends BaseMapper<Articulo, ArticuloDto>{
    @Override
    Articulo toEntity(ArticuloDto source);
}