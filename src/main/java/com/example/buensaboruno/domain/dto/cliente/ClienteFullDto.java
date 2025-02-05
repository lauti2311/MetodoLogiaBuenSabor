package com.example.buensaboruno.domain.dto.cliente;

import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.dto.domicilio.DomicilioFullDto;
import com.example.buensaboruno.domain.entities.Domicilio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteFullDto extends BaseDto {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    //private List<DomicilioFullDto> domicilios;

    @JsonIgnore
    private String clave;

}
