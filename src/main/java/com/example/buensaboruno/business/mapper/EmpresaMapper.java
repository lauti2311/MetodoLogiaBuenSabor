package com.example.buensaboruno.business.mapper;



import com.example.buensaboruno.domain.dto.empresa.EmpresaCreateDto;
import com.example.buensaboruno.domain.dto.empresa.EmpresaFullDto;
import com.example.buensaboruno.domain.entities.Empresa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpresaMapper extends BaseMapper<Empresa, EmpresaCreateDto> {


    EmpresaFullDto toLargeDto(Empresa empresa);


}
