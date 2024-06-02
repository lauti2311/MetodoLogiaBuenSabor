package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.provincia.ProvinciaFullDto;
import com.example.buensaboruno.domain.entities.Provincia;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProvinciaMapper extends BaseMapper<Provincia, ProvinciaFullDto>{

}
