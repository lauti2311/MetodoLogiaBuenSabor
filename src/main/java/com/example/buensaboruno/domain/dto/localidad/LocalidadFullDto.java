package com.example.buensaboruno.domain.dto.localidad;

import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.dto.provincia.ProvinciaFullDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LocalidadFullDto extends BaseDto {

    private Long id;
    private String nombre;
    private ProvinciaFullDto provincia;
}
