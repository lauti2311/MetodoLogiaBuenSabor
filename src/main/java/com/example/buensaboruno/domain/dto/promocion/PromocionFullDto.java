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
    private String fechaDesde; // Changed to String
    private String fechaHasta; // Changed to String
    @Schema(type = "string", format = "time", pattern = "HH:mm:ss", description = "Horario en formato HH:mm:ss")
    private String horaDesde; // Changed to String
    @Schema(type = "string", format = "time", pattern = "HH:mm:ss", description = "Horario en formato HH:mm:ss")
    private String horaHasta; // Changed to String
    private String descripcionDescuento;
    private Double precioPromocional;
    private TipoPromocion tipoPromocion;
    private Set<ImagenDto> imagenes;
    private Set<SucursalFullDto> sucursales;
    private Set<PromocionDetalleFullDto> promocionDetalle;

    // Add methods to set LocalDate and LocalTime as String
    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde.toString();
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta.toString();
    }

    public void setHoraDesde(LocalTime horaDesde) {
        this.horaDesde = horaDesde.toString();
    }

    public void setHoraHasta(LocalTime horaHasta) {
        this.horaHasta = horaHasta.toString();
    }
}