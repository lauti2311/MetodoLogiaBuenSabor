package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.imagen.ImagenDto;
import com.example.buensaboruno.domain.entities.ImagenEmpresa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ImagenEmpresaMapper extends BaseMapper<ImagenEmpresa, ImagenDto> {
}
