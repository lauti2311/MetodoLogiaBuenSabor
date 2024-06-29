package com.example.buensaboruno.domain.dto.sucursal;

import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.dto.domicilio.DomicilioShortDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SucursalShortDto extends BaseDto {
    private String nombre;
    private DomicilioShortDto domicilio;
//    private Set<ImagenDto> imagenes;
}
