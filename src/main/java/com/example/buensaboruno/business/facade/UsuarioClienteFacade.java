package com.example.buensaboruno.business.facade;


import com.example.buensaboruno.business.facade.Base.BaseFacade;
import com.example.buensaboruno.domain.dto.usuarioCliente.UsuarioClienteFullDto;
import com.example.buensaboruno.domain.entities.UsuarioCliente;

public interface UsuarioClienteFacade extends BaseFacade<UsuarioClienteFullDto, Long> {

    UsuarioCliente obtenerUsuarioClientePorEmail(String email);
}
