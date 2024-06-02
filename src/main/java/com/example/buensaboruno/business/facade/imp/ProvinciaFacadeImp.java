package com.example.buensaboruno.business.facade.imp;

import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.ProvinciaFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.business.service.ProvinciaService;
import com.example.buensaboruno.domain.dto.provincia.ProvinciaFullDto;
import com.example.buensaboruno.domain.entities.Provincia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaFacadeImp extends BaseFacadeImp<Provincia, ProvinciaFullDto, Long> implements ProvinciaFacade {

    public ProvinciaFacadeImp(BaseService<Provincia, Long> baseService, BaseMapper<Provincia, ProvinciaFullDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    ProvinciaService provinciaService;
    @Override
    public List<ProvinciaFullDto> findByPaisId(Long id) {
        return baseMapper.toDTOsList(provinciaService.findByPaisId(id));
    }
}
