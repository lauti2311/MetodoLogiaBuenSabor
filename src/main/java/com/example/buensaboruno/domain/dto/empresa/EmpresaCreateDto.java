package com.example.buensaboruno.domain.dto.empresa;


import com.example.buensaboruno.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpresaCreateDto extends BaseDto {

    private String nombre;
    private String razonSocial;
    private Long cuil;
//    private Set<ImagenDto> imagenes;
}

