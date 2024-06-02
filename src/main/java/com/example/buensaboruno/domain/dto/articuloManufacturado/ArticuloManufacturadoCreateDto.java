package com.example.buensaboruno.domain.dto.articuloManufacturado;

import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.dto.articuloManufacturadoDetalle.ArticuloManufacturadoDetalleCreateDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloManufacturadoCreateDto extends BaseDto {
    //de articulo
    private String denominacion;
    private Double precioVenta;
    //de imagenArticulo
//    private Set<ImagenDto> imagenes;
    //propios de la entidad
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;
    //de unidad medida
    private Long idUnidadMedida;
    //de articuloManufacturadoDetalle
    private Set<ArticuloManufacturadoDetalleCreateDto> ArticuloManufacturadoDetalles;
}
