package com.example.buensaboruno.domain.dto.domicilio;


import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.dto.localidad.LocalidadFullDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DomicilioFullDto extends BaseDto {

    private String calle;
    private Integer numero;
    private Integer cp;
    private Integer piso;
    private String nroDpto;
    private LocalidadFullDto localidad;

}
