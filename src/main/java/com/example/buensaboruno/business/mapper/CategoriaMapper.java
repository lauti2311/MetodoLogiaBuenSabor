package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.categoria.CategoriaCreateDto;
import com.example.buensaboruno.domain.entities.Categoria;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SucursalMapper.class})
public interface CategoriaMapper extends BaseMapper<Categoria, CategoriaCreateDto>{
    List<CategoriaCreateDto> categoriasToCategoriaCreateDto(List<Categoria> categorias);
}
