package com.example.buensaboruno.domain.dto.promocion;


import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.dto.imagen.ImagenDto;
import com.example.buensaboruno.domain.dto.promocionDetalle.PromocionDetalleFullDto;
import com.example.buensaboruno.domain.dto.sucursal.SucursalFullDto;
import com.example.buensaboruno.domain.enums.TipoPromocion;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PromocionFullDto extends BaseDto {
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    @Schema(type = "string", format = "time", pattern = "HH:mm:ss", description = "Horario en formato HH:mm:ss")
    private LocalTime horaDesde;
    @Schema(type = "string", format = "time", pattern = "HH:mm:ss", description = "Horario en formato HH:mm:ss")
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    private TipoPromocion tipoPromocion;
    private Set<ImagenDto> imagenes;
    private Set<SucursalFullDto> sucursales;
    private Set<PromocionDetalleFullDto> promocionDetalle;
}
