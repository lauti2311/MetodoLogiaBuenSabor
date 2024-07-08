package com.example.buensaboruno.domain.dto.articuloManufacturadoDetalle;

import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.dto.articuloInsumo.ArticuloInsumoShortDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloManufacturadoDetalleFullDto extends BaseDto {
    private Integer cantidad;
    private ArticuloInsumoShortDto articuloInsumo;
}
