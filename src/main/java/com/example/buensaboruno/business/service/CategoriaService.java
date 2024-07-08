package com.example.buensaboruno.business.service;


import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.dto.categoria.CategoriaCreateDto;
import com.example.buensaboruno.domain.entities.Categoria;

import java.util.List;

public interface CategoriaService extends BaseService<Categoria, Long> {

    List<CategoriaCreateDto> categoriaSucursal(Long idSucursal);
    List<CategoriaCreateDto> categoriaInsumoSucursal(Long idSucursal);
    List<CategoriaCreateDto> categoriaManufacturadoSucursal(Long idSucursal);
}
