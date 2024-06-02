package com.example.buensaboruno.business.service.Imp;


import com.example.buensaboruno.business.service.Base.BaseServiceImpl;
import com.example.buensaboruno.business.service.ProvinciaService;
import com.example.buensaboruno.domain.entities.Provincia;
import com.example.buensaboruno.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProvinciaServiceImpl extends BaseServiceImpl<Provincia, Long> implements ProvinciaService {

    @Autowired
    ProvinciaRepository provinciaRepository;
    @Override
    public List<Provincia> findByPaisId(Long id) {
        return provinciaRepository.findByPaisId(id);
    }
}
