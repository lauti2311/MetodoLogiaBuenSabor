package com.example.buensaboruno.service;


import com.example.buensaboruno.domain.entities.Pais;
import com.example.buensaboruno.repositories.PaisRepository;
import org.springframework.stereotype.Service;


@Service
public class PaisServiceImpl extends BaseServiceImpl<Pais, Long> implements PaisService {

    private PaisRepository paisRepository;
    public PaisServiceImpl(PaisRepository paisRepository) {
        super(paisRepository);
        this.paisRepository = paisRepository;
    }
}
