package com.example.buensaboruno.domain.dto.detallePedido;


import com.example.buensaboruno.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetallePedidoFullDto extends BaseDto {
    private Integer cantidad;
    private Double subTotal;
}
