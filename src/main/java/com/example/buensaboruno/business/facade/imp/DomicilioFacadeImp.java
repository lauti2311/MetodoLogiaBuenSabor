package com.example.buensaboruno.business.facade.imp;


import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.DomicilioFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.business.service.Imp.DomicilioServiceImpl;
import com.example.buensaboruno.domain.dto.domicilio.DomicilioFullDto;
import com.example.buensaboruno.domain.dto.localidad.LocalidadFullDto;
import com.example.buensaboruno.domain.entities.Domicilio;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomicilioFacadeImp extends BaseFacadeImp<Domicilio, DomicilioFullDto, Long> implements DomicilioFacade {
    @Autowired
    private DomicilioServiceImpl domicilioService;
    public DomicilioFacadeImp(BaseService<Domicilio, Long> baseService, BaseMapper<Domicilio, DomicilioFullDto> baseMapper) {
        super(baseService, baseMapper);
    }
    private List<DomicilioFullDto> domainToDto(List<Domicilio> domicilios) {
        return domicilios.stream()
                .map(domicilio -> {
                    DomicilioFullDto dto = new DomicilioFullDto();
                    BeanUtils.copyProperties(domicilio, dto);

                    // Manejo de la relación con Localidad
                    if (domicilio.getLocalidad() != null) {
                        LocalidadFullDto localidadDto = new LocalidadFullDto();
                        BeanUtils.copyProperties(domicilio.getLocalidad(), localidadDto);
                        // Aquí podrías necesitar mapear más propiedades específicas de Localidad si LocalidadFullDto tiene más campos que solo los básicos.
                        dto.setLocalidad(localidadDto);
                    } else {
                        dto.setLocalidad(null); // O podrías establecer un valor por defecto si prefieres
                    }

                    return dto;
                })
                .collect(Collectors.toList());
    }

    public List<DomicilioFullDto> getDomiciliosByCliente(Long clienteId) {
        List<Domicilio> domicilios = domicilioService.findByClienteId(clienteId);
        return this.domainToDto(domicilios);
    }
}
