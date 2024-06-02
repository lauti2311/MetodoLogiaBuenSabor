package com.example.buensaboruno.domain.dto.pais;

import com.example.buensaboruno.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaisFullDto extends BaseDto {
    private Long id;
    private String nombre;
}
