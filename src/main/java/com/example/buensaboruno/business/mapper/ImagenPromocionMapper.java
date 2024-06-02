package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.imagen.ImagenDto;
import com.example.buensaboruno.domain.entities.ImagenPromocion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ImagenPromocionMapper  extends BaseMapper<ImagenPromocion, ImagenDto> {
}
