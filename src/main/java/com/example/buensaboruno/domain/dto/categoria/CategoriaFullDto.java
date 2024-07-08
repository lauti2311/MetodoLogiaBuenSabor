package com.example.buensaboruno.domain.dto.categoria;

import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.dto.articuloInsumo.ArticuloInsumoFullDto;
import com.example.buensaboruno.domain.dto.articuloManufacturado.ArticuloManufacturadoFullDto;
import com.example.buensaboruno.domain.dto.sucursal.SucursalShortDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriaFullDto extends BaseDto {
    private String denominacion;
    private Boolean esInsumo;

    private Set<SucursalShortDto> sucursales;

    private Set<SubCategoriaFullDto> subCategorias;

    private Set<ArticuloInsumoFullDto> articuloInsumos;

    private Set<ArticuloManufacturadoFullDto> articulosManufacturados;

}
