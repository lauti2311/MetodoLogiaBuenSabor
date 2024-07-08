package com.example.buensaboruno.business.service;


import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.dto.pedido.PedidoFullDto;
import com.example.buensaboruno.domain.entities.Pedido;
import com.example.buensaboruno.domain.enums.Estado;

import java.time.Instant;
import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long> {

    List<Object[]> getRankingInsumo(Long sucursalId, Instant desde, Instant hasta);
    List<Object[]> getRankingInsumo(Long sucursalId);
    List<Object[]> getCantidadPedidosPorCliente(Long sucursalId, Instant desde, Instant hasta);
    List<Object[]> getCantidadPedidosPorCliente(Long sucursalId);
    List<Object[]> getIngresos(Long sucursalId, Instant desde, Instant hasta);
    List<Object[]> getIngresos(Long sucursalId);
    List<Object[]> getGanancias(Long sucursalId, Instant desde, Instant hasta);
    List<Object[]> getGanancias(Long sucursalId);

    Pedido cambiarEstado(Long pedidoId, Estado nuevoEstado);
    List<Pedido> getPedidosFiltrados(String rol);

    List<PedidoFullDto> findByClienteId(Long idCliente);
    List<PedidoFullDto> pedidosSucursal(Long idSucursal);

    Pedido getPedidoById(Long pedidoId);
}
