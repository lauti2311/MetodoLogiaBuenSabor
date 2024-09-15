package com.example.buensaboruno.business.service;


import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.entities.Usuario;

public interface UsuarioService extends BaseService<Usuario, Long> {

    Usuario obtenerUsuarioClientePorEmail(String email);
}
