package com.example.buensaboruno.domain.dto.promocionDetalle;


import com.example.buensaboruno.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PromocionDetalleCreateDto extends BaseDto {
    private Integer cantidad;
}
