package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.factura.FacturaFullDto;
import com.example.buensaboruno.domain.entities.Factura;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacturaMapper extends BaseMapper<Factura, FacturaFullDto>{
}
