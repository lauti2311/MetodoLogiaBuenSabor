package com.example.buensaboruno.business.facade;


import com.example.buensaboruno.business.facade.Base.BaseFacade;
import com.example.buensaboruno.domain.dto.localidad.LocalidadFullDto;

import java.util.List;

public interface LocalidadFacade extends BaseFacade<LocalidadFullDto, Long> {

    List<LocalidadFullDto> findByProvinciaId(Long id);
}
