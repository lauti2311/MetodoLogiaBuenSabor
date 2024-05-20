package com.example.buensaboruno.service;


import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.repositories.ClienteRepository;
import org.springframework.stereotype.Service;


@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService {

    private ClienteRepository clienteRepository;
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        super(clienteRepository);
        this.clienteRepository = clienteRepository;
    }
}
