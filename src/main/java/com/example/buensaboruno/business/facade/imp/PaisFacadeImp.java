package com.example.buensaboruno.business.facade.imp;


import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.PaisFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.dto.pais.PaisFullDto;
import com.example.buensaboruno.domain.entities.Pais;
import org.springframework.stereotype.Service;


@Service
public class PaisFacadeImp extends BaseFacadeImp<Pais, PaisFullDto,Long> implements PaisFacade {
    public PaisFacadeImp(BaseService<Pais, Long> baseService, BaseMapper<Pais, PaisFullDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
