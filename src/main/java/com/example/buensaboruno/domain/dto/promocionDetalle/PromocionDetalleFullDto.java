package com.example.buensaboruno.domain.dto.promocionDetalle;

import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.dto.articulo.ArticuloDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PromocionDetalleFullDto extends BaseDto {
    private Integer cantidad;
    private ArticuloDto articulo;
}
