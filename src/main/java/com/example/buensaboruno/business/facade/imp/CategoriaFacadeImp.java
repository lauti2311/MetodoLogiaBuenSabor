package com.example.buensaboruno.business.facade.imp;


import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.CategoriaFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.business.service.CategoriaService;
import com.example.buensaboruno.domain.dto.categoria.CategoriaCreateDto;
import com.example.buensaboruno.domain.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaFacadeImp extends BaseFacadeImp<Categoria, CategoriaCreateDto, Long> implements CategoriaFacade {

    @Autowired

    private CategoriaService categoriaService;
    public CategoriaFacadeImp(BaseService<Categoria, Long> baseService, BaseMapper<Categoria, CategoriaCreateDto> baseMapper) {
        super(baseService, baseMapper);
    }
    public List<CategoriaCreateDto> categoriaSucursal(Long idSucursal) {
        return this.categoriaService.categoriaSucursal(idSucursal);
    }
    public List<CategoriaCreateDto> categoriaInsumoSucursal(Long idSucursal) {
        return this.categoriaService.categoriaInsumoSucursal(idSucursal);
    }
    public List<CategoriaCreateDto> categoriaManufacturadoSucursal(Long idSucursal) {
        return this.categoriaService.categoriaManufacturadoSucursal(idSucursal);
    }
}
