package com.example.buensaboruno.domain.dto.articuloInsumo;

import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.dto.categoria.CategoriaCreateDto;
import com.example.buensaboruno.domain.dto.imagen.ImagenDto;
import com.example.buensaboruno.domain.dto.sucursal.SucursalShortDto;
import com.example.buensaboruno.domain.dto.unidadMedida.UnidadMedidaFullDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloInsumoFullDto extends BaseDto {
    //de articulo
    private Long articuloId;
    private String denominacion;
    private String precioVenta;
    //propios de la clase
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Integer stockMinimo;
    private Boolean esParaElaborar;
    //de unidadMedida
    private UnidadMedidaFullDto unidadMedida;
    //de categoria
    private CategoriaCreateDto categoria;
    private Set<ImagenDto> imagenes;
    //sucursal
    private SucursalShortDto sucursal;

}
