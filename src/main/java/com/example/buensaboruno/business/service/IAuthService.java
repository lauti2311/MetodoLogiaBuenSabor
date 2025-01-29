package com.example.buensaboruno.business.service;

import com.example.buensaboruno.config.security.LoginDTO;
import com.example.buensaboruno.config.security.ResponseDTO;
import com.example.buensaboruno.domain.dto.domicilio.DomicilioFullDto;
import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.domain.entities.Domicilio;
import com.example.buensaboruno.domain.entities.Empleado;


import java.util.HashMap;
import java.util.Set;

public interface IAuthService {
    public HashMap<String, String> login(LoginDTO login) throws Exception;
    public ResponseDTO register(Empleado empleado) throws Exception;
    Empleado getEmpleadoById(Long id);
    public HashMap<String, String> loginCliente(LoginDTO login) throws Exception;
    public ResponseDTO registerCliente(Cliente cliente) throws Exception;
    Cliente getClienteById(Long id);

    ResponseDTO agregarDomiciliosACliente(Long clienteId, Set<DomicilioFullDto> nuevosDomicilios);
}
