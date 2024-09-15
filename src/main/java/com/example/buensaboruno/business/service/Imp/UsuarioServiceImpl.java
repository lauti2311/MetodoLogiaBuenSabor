package com.example.buensaboruno.business.service.Imp;


import com.example.buensaboruno.business.service.Base.BaseServiceImpl;
import com.example.buensaboruno.business.service.UsuarioService;
import com.example.buensaboruno.domain.entities.Usuario;
import com.example.buensaboruno.repositories.UsuarioClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;

    public Usuario obtenerUsuarioClientePorEmail(String email) {
        Usuario usuario = this.usuarioClienteRepository.findFirstByEmail(email);

        if(usuario == null) {
            throw new RuntimeException("El usuario no esta registrado para operar");
        }

        return usuario;
    }
}
