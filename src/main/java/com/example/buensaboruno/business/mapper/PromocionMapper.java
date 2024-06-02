package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dto.promocion.PromocionFullDto;
import com.example.buensaboruno.domain.entities.Promocion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SucursalMapper.class})
public interface PromocionMapper extends BaseMapper<Promocion, PromocionFullDto>{
}
