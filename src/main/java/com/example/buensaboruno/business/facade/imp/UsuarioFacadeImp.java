package com.example.buensaboruno.business.facade.imp;


import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.UsuarioFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.business.service.UsuarioService;
import com.example.buensaboruno.domain.dto.usuarioCliente.UsuarioClienteFullDto;
import com.example.buensaboruno.domain.entities.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioFacadeImp extends BaseFacadeImp<Usuario, UsuarioClienteFullDto, Long> implements UsuarioFacade {

    private UsuarioService usuarioService;
    public UsuarioFacadeImp(BaseService<Usuario, Long> baseService, BaseMapper<Usuario, UsuarioClienteFullDto> baseMapper, UsuarioService usuarioService) {
        super(baseService, baseMapper);
        this.usuarioService = usuarioService;
    }

    public Usuario obtenerUsuarioClientePorEmail(String email) {
        return this.usuarioService.obtenerUsuarioClientePorEmail(email);
    }
}
