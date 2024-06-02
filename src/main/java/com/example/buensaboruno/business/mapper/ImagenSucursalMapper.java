package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.imagen.ImagenDto;
import com.example.buensaboruno.domain.entities.ImagenSucursal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImagenSucursalMapper extends BaseMapper<ImagenSucursal, ImagenDto> {
}
