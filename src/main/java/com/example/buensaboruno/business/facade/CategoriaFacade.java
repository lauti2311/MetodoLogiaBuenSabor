package com.example.buensaboruno.business.facade;


import com.example.buensaboruno.business.facade.Base.BaseFacade;
import com.example.buensaboruno.domain.dto.categoria.CategoriaCreateDto;

import java.util.List;

public interface CategoriaFacade extends BaseFacade<CategoriaCreateDto, Long> {

    List<CategoriaCreateDto> categoriaSucursal(Long idSucursal);
    List<CategoriaCreateDto> categoriaInsumoSucursal(Long idSucursal);
    List<CategoriaCreateDto> categoriaManufacturadoSucursal(Long idSucursal);
}
