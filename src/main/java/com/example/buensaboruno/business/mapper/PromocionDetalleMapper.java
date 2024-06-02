package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.promocionDetalle.PromocionDetalleFullDto;
import com.example.buensaboruno.domain.entities.PromocionDetalle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface PromocionDetalleMapper extends BaseMapper<PromocionDetalle, PromocionDetalleFullDto>{
}
