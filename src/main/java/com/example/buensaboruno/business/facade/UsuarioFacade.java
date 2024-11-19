package com.example.buensaboruno.business.facade;


import com.example.buensaboruno.business.facade.Base.BaseFacade;
import com.example.buensaboruno.domain.dto.usuarioCliente.UsuarioClienteFullDto;
import com.example.buensaboruno.domain.entities.Usuario;

public interface UsuarioFacade extends BaseFacade<UsuarioClienteFullDto, Long> {

    Usuario obtenerUsuarioClientePorEmail(String email);
}
