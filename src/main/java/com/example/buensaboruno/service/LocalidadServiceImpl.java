package com.example.buensaboruno.service;


import com.example.buensaboruno.domain.entities.Localidad;
import com.example.buensaboruno.repositories.LocalidadRepository;
import org.springframework.stereotype.Service;


@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {

    private LocalidadRepository localidadRepository;
    public LocalidadServiceImpl(LocalidadRepository localidadRepository) {
        super(localidadRepository);
        this.localidadRepository = localidadRepository;
    }
}
