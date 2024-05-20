package com.example.buensaboruno.service;


import com.example.buensaboruno.domain.entities.UsuarioEmpleado;
import com.example.buensaboruno.repositories.UsuarioEmpleadoRepository;
import org.springframework.stereotype.Service;


@Service
public class UsuarioEmpleadoServiceImpl extends BaseServiceImpl<UsuarioEmpleado, Long> implements UsuarioEmpleadoService {

    private UsuarioEmpleadoRepository usuarioEmpleadoRepository;
    public UsuarioEmpleadoServiceImpl(UsuarioEmpleadoRepository usuarioEmpleadoRepository) {
        super(usuarioEmpleadoRepository);
        this.usuarioEmpleadoRepository = usuarioEmpleadoRepository;
    }
}
