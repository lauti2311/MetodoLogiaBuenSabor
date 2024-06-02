package com.example.buensaboruno.business.facade.imp;


import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.UsuarioClienteFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.dto.usuarioCliente.UsuarioClienteFullDto;
import com.example.buensaboruno.domain.entities.UsuarioCliente;
import org.springframework.stereotype.Service;

@Service
public class UsuarioClienteFacadeImp extends BaseFacadeImp<UsuarioCliente, UsuarioClienteFullDto, Long> implements UsuarioClienteFacade {

    public UsuarioClienteFacadeImp(BaseService<UsuarioCliente, Long> baseService, BaseMapper<UsuarioCliente, UsuarioClienteFullDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
