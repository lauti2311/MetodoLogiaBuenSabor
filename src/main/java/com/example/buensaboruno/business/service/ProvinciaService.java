package com.example.buensaboruno.business.service;


import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.entities.Provincia;

import java.util.List;

public interface ProvinciaService extends BaseService<Provincia, Long> {
    List<Provincia> findByPaisId(Long id);

}
