package com.example.buensaboruno.business.service.Imp;


import com.example.buensaboruno.business.service.Base.BaseServiceImpl;
import com.example.buensaboruno.business.service.UsuarioClienteService;
import com.example.buensaboruno.domain.entities.UsuarioCliente;
import com.example.buensaboruno.repositories.UsuarioClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioClienteServiceImpl extends BaseServiceImpl<UsuarioCliente, Long> implements UsuarioClienteService {

    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;

    public UsuarioCliente obtenerUsuarioClientePorEmail(String email) {
        UsuarioCliente usuarioCliente = this.usuarioClienteRepository.findFirstByEmail(email);

        if(usuarioCliente == null) {
            throw new RuntimeException("El usuario no esta registrado para operar");
        }

        return usuarioCliente;
    }
}
