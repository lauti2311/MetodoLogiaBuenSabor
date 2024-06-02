package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.domicilio.DomicilioFullDto;
import com.example.buensaboruno.domain.entities.Domicilio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = LocalidadMapper.class)
public interface DomicilioMapper extends BaseMapper<Domicilio, DomicilioFullDto> {


}
