package com.example.buensaboruno.business.facade.imp;


import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.ClienteFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.business.service.ClienteService;
import com.example.buensaboruno.domain.dto.cliente.ClienteFullDto;
import com.example.buensaboruno.domain.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteFacadeImp extends BaseFacadeImp<Cliente, ClienteFullDto, Long> implements ClienteFacade {

    @Autowired
    private ClienteService clienteService;
    public ClienteFacadeImp(BaseService<Cliente, Long> baseService, BaseMapper<Cliente, ClienteFullDto> baseMapper) {
        super(baseService, baseMapper);
    }


}
