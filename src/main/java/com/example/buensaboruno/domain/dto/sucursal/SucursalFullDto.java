package com.example.buensaboruno.domain.dto.sucursal;


import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.dto.domicilio.DomicilioFullDto;
import com.example.buensaboruno.domain.dto.empresa.EmpresaCreateDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SucursalFullDto extends BaseDto {

    private String nombre;
    @Schema(type = "string", format = "time", pattern = "HH:mm:ss", description = "Horario de apertura en formato HH:mm:ss")
    private LocalTime horarioApertura;
    @Schema(type = "string", format = "time", pattern = "HH:mm:ss", description = "Horario de cierre en formato HH:mm:ss")
    private LocalTime horarioCierre;
    private boolean esCasaMatriz;

    private DomicilioFullDto domicilio;
    private EmpresaCreateDto empresa;
//    private Set<ImagenDto> imagenes;

}