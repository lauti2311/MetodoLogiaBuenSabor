package com.example.buensaboruno.domain.dto.pedido;

import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.dto.cliente.ClienteFullDto;
import com.example.buensaboruno.domain.dto.detallePedido.DetallePedidoFullDto;
import com.example.buensaboruno.domain.dto.domicilio.DomicilioFullDto;
import com.example.buensaboruno.domain.dto.sucursal.SucursalShortDto;
import com.example.buensaboruno.domain.dto.usuarioCliente.UsuarioDto;
import com.example.buensaboruno.domain.entities.Factura;
import com.example.buensaboruno.domain.enums.Estado;
import com.example.buensaboruno.domain.enums.FormaPago;
import com.example.buensaboruno.domain.enums.TipoEnvio;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class PedidoFullDto extends BaseDto {
    @Schema(type = "string", format = "time", pattern = "HH:mm:ss", description = "Horario de apertura en formato HH:mm:ss")
    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;
    private Set<DetallePedidoFullDto> detallePedidos;
    private Factura factura;
    private SucursalShortDto sucursal;
    private ClienteFullDto cliente;

    @JsonIgnore
    private DomicilioFullDto domicilio;
}
