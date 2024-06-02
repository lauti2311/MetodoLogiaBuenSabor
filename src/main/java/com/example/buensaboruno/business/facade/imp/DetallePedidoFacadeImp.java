package com.example.buensaboruno.business.facade.imp;


import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.DetallePedidoFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.dto.detallePedido.DetallePedidoFullDto;
import com.example.buensaboruno.domain.entities.DetallePedido;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoFacadeImp extends BaseFacadeImp<DetallePedido, DetallePedidoFullDto, Long> implements DetallePedidoFacade {

    public DetallePedidoFacadeImp(BaseService<DetallePedido, Long> baseService, BaseMapper<DetallePedido, DetallePedidoFullDto> baseMapper) {
        super(baseService, baseMapper);
    }

}
