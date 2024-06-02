package com.example.buensaboruno.business.facade.imp;


import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.LocalidadFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.business.service.LocalidadService;
import com.example.buensaboruno.domain.dto.localidad.LocalidadFullDto;
import com.example.buensaboruno.domain.entities.Localidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalidadFacadeImp extends BaseFacadeImp<Localidad, LocalidadFullDto, Long> implements LocalidadFacade {
    public LocalidadFacadeImp(BaseService<Localidad, Long> baseService, BaseMapper<Localidad, LocalidadFullDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    LocalidadService localidadService;

    @Override
    public List<LocalidadFullDto> findByProvinciaId(Long id) {
            // trae una lista de entidades
            var entities = localidadService.findByProvinciaId(id);
            //  devuelve una lista de DTO
            return entities
                    .stream()
                    .map(baseMapper::toDTO)
                    .collect(Collectors.toList());
    }
}
