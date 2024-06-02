package com.example.buensaboruno.business.facade.imp;

import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.UnidadMedidaFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.dto.unidadMedida.UnidadMedidaFullDto;
import com.example.buensaboruno.domain.entities.UnidadMedida;
import org.springframework.stereotype.Service;


@Service
public class UnidadMedidaFacadeImp extends BaseFacadeImp<UnidadMedida, UnidadMedidaFullDto,Long> implements UnidadMedidaFacade {
    public UnidadMedidaFacadeImp(BaseService<UnidadMedida, Long> baseService, BaseMapper<UnidadMedida, UnidadMedidaFullDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
