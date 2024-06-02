package com.example.buensaboruno.business.facade;


import com.example.buensaboruno.business.facade.Base.BaseFacade;
import com.example.buensaboruno.domain.dto.provincia.ProvinciaFullDto;

import java.util.List;

public interface ProvinciaFacade extends BaseFacade<ProvinciaFullDto, Long> {
    List<ProvinciaFullDto> findByPaisId(Long id);
}
