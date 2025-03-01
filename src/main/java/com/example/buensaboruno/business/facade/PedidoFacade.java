package com.example.buensaboruno.business.facade;


import com.example.buensaboruno.business.facade.Base.BaseFacade;
import com.example.buensaboruno.domain.dto.pedido.PedidoCreateDto;
import com.example.buensaboruno.domain.dto.pedido.PedidoFullDto;
import com.example.buensaboruno.domain.entities.Pedido;
import com.example.buensaboruno.domain.enums.Estado;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.ByteArrayOutputStream;
import java.time.Instant;
import java.util.List;

public interface PedidoFacade extends BaseFacade<PedidoFullDto, Long> {
    SXSSFWorkbook getRankingInsumo(Long sucursalId, Instant desde, Instant hasta);

    List<Object[]> getRankingInsumoData(Long sucursalId);

    List<Object[]> getCantidadDePedidosPorData(Long sucursalId);

    List<Object[]> getIngresosData(Long sucursalId);

    List<Object[]> getGananciasData(Long sucursalId);

    SXSSFWorkbook getCantidadDePedidosPorCliente(Long sucursalId, Instant desde, Instant hasta);

    Pedido cambiarEstado(Long pedidoId, Estado nuevoEstado);

    List<Pedido> getPedidosFiltrados(String rol);

    @Query(value = "SELECT p.* FROM pedido u " +
            "WHERE p.cliente_id = :clienteId ", nativeQuery = true)
    List<PedidoFullDto> findByClienteId(@Param("cliente_id") Long clienteId);
    List<PedidoFullDto> pedidosSucursal(Long idSucursal);

    ByteArrayOutputStream generatePedidoPDF(Long pedidoId);

    PedidoFullDto createPedido(PedidoCreateDto pedidoDto);


}
