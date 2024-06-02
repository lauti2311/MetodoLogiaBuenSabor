package com.example.buensaboruno.domain.dto.empresa;


import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.dto.imagen.ImagenDto;
import com.example.buensaboruno.domain.dto.sucursal.SucursalFullDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpresaFullDto extends BaseDto {
    private String nombre;
    private String razonSocial;
    private Long cuil;
    private Set<SucursalFullDto> sucursales;
    private Set<ImagenDto> imagenes;
}
