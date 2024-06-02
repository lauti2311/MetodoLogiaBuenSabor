package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.imagen.ImagenDto;
import com.example.buensaboruno.domain.entities.ImagenArticulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ImagenArticuloMapper extends BaseMapper<ImagenArticulo, ImagenDto> {
}
