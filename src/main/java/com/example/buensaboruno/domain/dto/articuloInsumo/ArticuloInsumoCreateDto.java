package com.example.buensaboruno.domain.dto.articuloInsumo;


import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.dto.categoria.CategoriaCreateDto;
import com.example.buensaboruno.domain.dto.unidadMedida.UnidadMedidaFullDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloInsumoCreateDto extends BaseDto {
    //de articulo
    private String denominacion;
    private String precioVenta;
    //propios de la clase
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Boolean esParaElaborar;
    //de unidadMedida
    private UnidadMedidaFullDto unidadMedida;
    //de categoria
    private CategoriaCreateDto categoria;
//    private Set<ImagenDto> imagenes;
}
