package com.example.buensaboruno.domain.dto.cliente;

import com.example.buensaboruno.domain.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteFullDto extends BaseDto {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    @JsonIgnore
    private String clave;

}
