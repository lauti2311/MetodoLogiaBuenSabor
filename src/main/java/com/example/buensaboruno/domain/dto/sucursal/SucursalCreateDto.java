package com.example.buensaboruno.domain.dto.sucursal;


import com.example.buensaboruno.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SucursalCreateDto extends BaseDto {
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean esCasaMatriz;

    private Long idDomicilio;
    private Long idEmpresa;
//    private Set<ImagenDto> imagenes;

}
