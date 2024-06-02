package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.pais.PaisFullDto;
import com.example.buensaboruno.domain.entities.Pais;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaisMapper extends BaseMapper<Pais, PaisFullDto>{

}
