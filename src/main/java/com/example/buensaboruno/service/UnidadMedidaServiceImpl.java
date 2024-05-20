package com.example.buensaboruno.service;

import com.example.buensaboruno.domain.entities.UnidadMedida;
import com.example.buensaboruno.repositories.UnidadMedidaRepository;
import org.springframework.stereotype.Service;


@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida, Long> implements UnidadMedidaService {

    private UnidadMedidaRepository unidadMedidaRepository;
    public UnidadMedidaServiceImpl(UnidadMedidaRepository unidadMedidaRepository) {
        super(unidadMedidaRepository);
        this.unidadMedidaRepository = unidadMedidaRepository;
    }
}
