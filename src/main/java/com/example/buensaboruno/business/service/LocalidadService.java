package com.example.buensaboruno.business.service;


import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.entities.Localidad;

import java.util.List;

public interface LocalidadService extends BaseService<Localidad, Long> {
    List<Localidad> findByProvinciaId(Long id);
}
