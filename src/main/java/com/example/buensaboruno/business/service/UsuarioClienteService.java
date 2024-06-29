package com.example.buensaboruno.business.service;


import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.entities.UsuarioCliente;

public interface UsuarioClienteService extends BaseService<UsuarioCliente, Long> {

    UsuarioCliente obtenerUsuarioClientePorEmail(String email);
}
