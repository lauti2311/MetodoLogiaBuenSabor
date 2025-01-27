package com.example.buensaboruno.domain.dto.provincia;

import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.dto.pais.PaisFullDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProvinciaFullDto extends BaseDto {
    private Long id;
    private String nombre;
    private PaisFullDto pais;
}
