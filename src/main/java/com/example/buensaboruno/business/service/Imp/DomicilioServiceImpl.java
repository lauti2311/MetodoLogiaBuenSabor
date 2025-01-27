package com.example.buensaboruno.business.service.Imp;

import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.repositories.ClienteRepository;
import com.example.buensaboruno.repositories.DomicilioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.buensaboruno.business.service.Base.BaseServiceImpl;
import com.example.buensaboruno.business.service.DomicilioService;
import com.example.buensaboruno.domain.entities.Domicilio;

import java.util.ArrayList;
import java.util.List;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private DomicilioRepository domicilioRepository;



    public List<Domicilio> findByClienteId(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        return new ArrayList<>(cliente.getDomicilios());
    }

}
