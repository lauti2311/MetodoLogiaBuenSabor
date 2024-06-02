package com.example.buensaboruno.business.facade.imp;


import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.PedidoFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.dto.pedido.PedidoFullDto;
import com.example.buensaboruno.domain.entities.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidoFacadeImp extends BaseFacadeImp<Pedido, PedidoFullDto, Long> implements PedidoFacade {

    public PedidoFacadeImp(BaseService<Pedido, Long> baseService, BaseMapper<Pedido, PedidoFullDto> baseMapper) {
        super(baseService, baseMapper);
    }

}
