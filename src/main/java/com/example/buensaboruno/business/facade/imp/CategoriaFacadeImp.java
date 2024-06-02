package com.example.buensaboruno.business.facade.imp;


import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.CategoriaFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.dto.categoria.CategoriaCreateDto;
import com.example.buensaboruno.domain.entities.Categoria;
import org.springframework.stereotype.Service;

@Service
public class CategoriaFacadeImp extends BaseFacadeImp<Categoria, CategoriaCreateDto, Long> implements CategoriaFacade {

    public CategoriaFacadeImp(BaseService<Categoria, Long> baseService, BaseMapper<Categoria, CategoriaCreateDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
