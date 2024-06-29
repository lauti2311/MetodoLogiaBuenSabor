package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.sucursal.SucursalFullDto;
import com.example.buensaboruno.domain.entities.Sucursal;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DomicilioMapper.class, EmpresaMapper.class })
public interface SucursalMapper extends BaseMapper<Sucursal, SucursalFullDto>{
    List<SucursalFullDto> sucursalesToSucursalFullDto(List<Sucursal> sucursales);
}
