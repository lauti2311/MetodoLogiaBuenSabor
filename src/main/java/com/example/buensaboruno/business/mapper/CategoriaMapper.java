package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.categoria.CategoriaCreateDto;
import com.example.buensaboruno.domain.entities.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SucursalMapper.class})
public interface CategoriaMapper extends BaseMapper<Categoria, CategoriaCreateDto>{
}
