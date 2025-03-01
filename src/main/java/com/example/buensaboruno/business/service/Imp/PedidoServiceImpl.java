package com.example.buensaboruno.business.service.Imp;

import com.example.buensaboruno.business.mapper.PedidoMapper;
import com.example.buensaboruno.business.service.Base.BaseServiceImpl;
import com.example.buensaboruno.business.service.JWTUtilityService;
import com.example.buensaboruno.business.service.PedidoService;
import com.example.buensaboruno.domain.dto.pedido.PedidoFullDto;
import com.example.buensaboruno.domain.entities.*;
import com.example.buensaboruno.domain.enums.Estado;
import com.example.buensaboruno.repositories.*;
import com.nimbusds.jwt.JWTClaimsSet;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;


@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {


    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    DetallePedidoRepository detallePedidoRepository;

    @Autowired
    ArticuloRepository articuloRepository;

    @Autowired
    SucursalRepository sucursalRepository;

    @Autowired
    DomicilioRepository domicilioRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    private JWTUtilityService jwtUtilityService;

    @Autowired
    private PedidoMapper pedidoMapper;

    public List<PedidoFullDto> findByClienteId(Long clienteId) {
        List<Pedido> pedidos = this.pedidoRepository.findByClienteId(clienteId);
        return pedidoMapper.pedidosToPedidoFullDtos(pedidos);
    }
    public List<PedidoFullDto> pedidosSucursal(Long idSucursal) {
        List<Pedido> pedidos = this.pedidoRepository.pedidosSucursal(idSucursal);
        return pedidoMapper.pedidosToPedidoFullDtos(pedidos);
    }
    @Override
    public Pedido create(Pedido request) {
        try {
            // Obtener el token JWT desde el contexto de seguridad
            String authHeader = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest().getHeader("Authorization");

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new RuntimeException("Token JWT no presente o inválido.");
            }

            String token = authHeader.substring(7); // Eliminar "Bearer "

            // Obtener el sub (ID del cliente) desde el token
            JWTClaimsSet claims = jwtUtilityService.parseJWT(token);
            String clienteId = claims.getSubject(); // El 'sub' contiene el ID del cliente

            if (clienteId == null || clienteId.isEmpty()) {
                throw new RuntimeException("No se pudo obtener el cliente desde el token JWT.");
            }

            // Buscar el cliente en el repositorio
            Cliente cliente = clienteRepository.findById(Long.parseLong(clienteId))
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

            request.setCliente(cliente);

            // Validar la sucursal
            if (request.getSucursal() == null) {
                throw new RuntimeException("No se ha asignado una sucursal al pedido");
            }

            Sucursal sucursal = sucursalRepository.findById(request.getSucursal().getId())
                    .orElseThrow(() -> new RuntimeException("La sucursal con id " + request.getSucursal().getId() + " no se ha encontrado"));

            // Verificar y asignar el domicilio
            // Verificar y asignar el domicilio
            Domicilio domicilioRequest = request.getDomicilio();
            if (domicilioRequest != null && domicilioRequest.getId() != null) {
                final Long domicilioId = domicilioRequest.getId();  // Guardar el id en una variable final
                Domicilio domicilio = domicilioRepository.findById(domicilioId)
                        .orElseThrow(() -> new RuntimeException("Domicilio con id " + domicilioId + " no encontrado"));
                request.setDomicilio(domicilio);
            } else if (domicilioRequest != null) {
                Domicilio domicilio = domicilioRepository.save(domicilioRequest);
                request.setDomicilio(domicilio);
            } else if (cliente.getDomicilios() != null && !cliente.getDomicilios().isEmpty()) {
                request.setDomicilio(cliente.getDomicilios().iterator().next());
            } else {
                throw new RuntimeException("El cliente no tiene un domicilio válido.");
            }


            // Procesar detalles del pedido
            Set<DetallePedido> detalles = request.getDetallePedidos();
            Set<DetallePedido> detallesPersistidos = new HashSet<>();

            if (detalles != null && !detalles.isEmpty()) {
                double costoTotal = 0;
                for (DetallePedido detalle : detalles) {
                    Articulo articulo = detalle.getArticulo();
                    if (articulo == null || articulo.getId() == null) {
                        throw new RuntimeException("El artículo del detalle no puede ser nulo.");
                    }
                    articulo = articuloRepository.findById(detalle.getArticulo().getId())
                            .orElseThrow(() -> new RuntimeException("Artículo con id " + detalle.getArticulo().getId() + " inexistente"));
                    detalle.setArticulo(articulo);
                    DetallePedido savedDetalle = detallePedidoRepository.save(detalle);
                    costoTotal += calcularTotalCosto(articulo, detalle.getCantidad());
                    descontarStock(articulo, detalle.getCantidad());
                    detallesPersistidos.add(savedDetalle);
                }
                request.setTotalCosto(costoTotal);
                request.setDetallePedidos(detallesPersistidos);
            } else {
                throw new IllegalArgumentException("El pedido debe contener un detalle o más.");
            }

            // Asignar domicilio, sucursal y fecha
            //request.setDomicilio(domicilio);
            request.setSucursal(sucursal);
            request.setFechaPedido(LocalDate.now());

            // Guardar el pedido
            return pedidoRepository.save(request);

        } catch (Exception e) {
            throw new RuntimeException("Error al crear el pedido: " + e.getMessage(), e);
        }
    }


    @Transactional
    public Articulo descontarStock(Articulo articulo, int cantidad) {
        if (articulo instanceof ArticuloInsumo) {

            ArticuloInsumo insumo = (ArticuloInsumo) articulo;
            System.out.println("Stock antes de descontar: " + insumo.getStockActual());
            int stockDescontado = insumo.getStockActual() - cantidad; // Descontar cantidad a stock actual
            System.out.println("Stock después de restarle la cantidad: " + stockDescontado);

            // Validar que el stock actual no supere el mínimo
            if (stockDescontado <= insumo.getStockMinimo()) {
                throw new RuntimeException("El insumo " + insumo.getDenominacion() + " alcanzó el stock mínimo: " + stockDescontado);
            }

            // Asignarle al insumo
            insumo.setStockActual(stockDescontado);
            return insumo; // Return the updated insumo

        } else if (articulo instanceof ArticuloManufacturado) {
            // Cast the articulo to ArticuloManufacturado
            ArticuloManufacturado manufacturado = (ArticuloManufacturado) articulo;
            // Obtener los detalles del manufacturado
            Set<ArticuloManufacturadoDetalle> detalles = manufacturado.getArticuloManufacturadoDetalles();

            if (detalles != null && !detalles.isEmpty()) {
                for (ArticuloManufacturadoDetalle detalle : detalles) {
                    ArticuloInsumo insumo = detalle.getArticuloInsumo();
                    int cantidadInsumo = detalle.getCantidad() * cantidad;
                    int stockDescontado = insumo.getStockActual() - cantidadInsumo;
                    if (stockDescontado <= insumo.getStockMinimo()) {
                        throw new RuntimeException("El insumo con id " + insumo.getId() + " (" + insumo.getDenominacion() + ") presente en el artículo "
                                + manufacturado.getDenominacion() + " (id " + manufacturado.getId() + ") alcanzó el stock mínimo: " + stockDescontado);
                    }
                    insumo.setStockActual(stockDescontado);
                }
            }
            return manufacturado;
        } else {
            throw new RuntimeException("Artículo de tipo desconocido con id " + articulo.getId());
        }
    }

    public Double calcularTotalCosto(Articulo articulo, Integer cantidad) {
        if (articulo instanceof ArticuloInsumo) { // verifico si es articuloInsumo
            ArticuloInsumo insumo = (ArticuloInsumo) articulo;
            return insumo.getPrecioCompra() * cantidad;
        } else if (articulo instanceof ArticuloManufacturado) { //verifico si es articuloManufacturado
            ArticuloManufacturado manufacturado = (ArticuloManufacturado) articulo;
            Set<ArticuloManufacturadoDetalle> detalles = manufacturado.getArticuloManufacturadoDetalles();

            if (detalles != null && !detalles.isEmpty()) {
                double totalCosto = 0;
                for (ArticuloManufacturadoDetalle detalle : detalles) {
                    double precioCompraInsumo = detalle.getArticuloInsumo().getPrecioCompra();
                    double cantidadInsumo = detalle.getCantidad();
                    totalCosto += (precioCompraInsumo * cantidadInsumo);
                }
                // Multiplicar por la cantidad de artículos manufacturados
                return totalCosto * cantidad;
            }
        }
        return 0.0;
    }

    @Override
    public List<Object[]> getRankingInsumo(Long sucursalId, Instant desde, Instant hasta) {
        ZoneId zoneId = ZoneId.systemDefault();

        return pedidoRepository.getRankingInsumos(sucursalId, ZonedDateTime.ofInstant(desde, zoneId).toLocalDate(), ZonedDateTime.ofInstant(hasta, zoneId).toLocalDate());
    }

    @Override
    public List<Object[]> getRankingInsumo(Long sucursalId) {
        return pedidoRepository.getRankingInsumos(sucursalId);
    }

    @Override
    public List<Object[]> getCantidadPedidosPorCliente(Long sucursalId, Instant desde, Instant hasta) {
        ZoneId zoneId = ZoneId.systemDefault();

        return pedidoRepository.getCantidadPedidosPorCliente(sucursalId, ZonedDateTime.ofInstant(desde, zoneId).toLocalDate(), ZonedDateTime.ofInstant(hasta, zoneId).toLocalDate());
    }

    @Override
    public List<Object[]> getCantidadPedidosPorCliente(Long sucursalId) {
        return pedidoRepository.getCantidadPedidosPorCliente(sucursalId);
    }

    @Override
    public List<Object[]> getIngresos(Long sucursalId, Instant desde, Instant hasta) {
        ZoneId zoneId = ZoneId.systemDefault();

        return pedidoRepository.getIngresos(sucursalId, ZonedDateTime.ofInstant(desde, zoneId).toLocalDate(), ZonedDateTime.ofInstant(hasta, zoneId).toLocalDate());
    }

    @Override
    public List<Object[]> getIngresos(Long sucursalId) {
        return pedidoRepository.getIngresos(sucursalId);
    }

    @Override
    public List<Object[]> getGanancias(Long sucursalId, Instant desde, Instant hasta) {
        ZoneId zoneId = ZoneId.systemDefault();

        return pedidoRepository.getGanancias(sucursalId, ZonedDateTime.ofInstant(desde, zoneId).toLocalDate(), ZonedDateTime.ofInstant(hasta, zoneId).toLocalDate());
    }

    @Override
    public List<Object[]> getGanancias(Long sucursalId) {
        return pedidoRepository.getGanancias(sucursalId);
    }

    @Override
    public Pedido cambiarEstado(Long pedidoId, Estado nuevoEstado) {
        Pedido pedido = pedidoRepository.findById(pedidoId).orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));
        pedido.setEstado(nuevoEstado);

        if(nuevoEstado == Estado.RECHAZADO){
            Set<DetallePedido> detalles = pedido.getDetallePedidos();
            Set<DetallePedido> detallesPersistidos = new HashSet<>();

            if (detalles != null && !detalles.isEmpty()) {
                for (DetallePedido detalle : detalles) {
                    Articulo articulo = detalle.getArticulo();
                    articulo = articuloRepository.findById(detalle.getArticulo().getId())
                            .orElseThrow(() -> new RuntimeException("Artículo con id " + detalle.getArticulo().getId() + " inexistente"));
                    detalle.setArticulo(articulo);
                    DetallePedido savedDetalle = detallePedidoRepository.save(detalle);
                    incrementarStocl(articulo, detalle.getCantidad());
                    detallesPersistidos.add(savedDetalle);
                }
            } else {
                throw new IllegalArgumentException("El pedido debe contener un detalle o más.");
            }
        }

        return pedidoRepository.save(pedido);
    }
    @Transactional
    public Articulo incrementarStocl(Articulo articulo, int cantidad) {
        if (articulo instanceof ArticuloInsumo) {

            ArticuloInsumo insumo = (ArticuloInsumo) articulo;
            System.out.println("Stock antes de incrementar: " + insumo.getStockActual());
            int stockDescontado = insumo.getStockActual() + cantidad; // Descontar cantidad a stock actual
            System.out.println("Stock después de agregarle la cantidad: " + stockDescontado);

            // Asignarle al insumo
            insumo.setStockActual(stockDescontado);
            return insumo; // Return the updated insumo

        } else if (articulo instanceof ArticuloManufacturado) {
            // Cast the articulo to ArticuloManufacturado
            ArticuloManufacturado manufacturado = (ArticuloManufacturado) articulo;
            // Obtener los detalles del manufacturado
            Set<ArticuloManufacturadoDetalle> detalles = manufacturado.getArticuloManufacturadoDetalles();

            if (detalles != null && !detalles.isEmpty()) {
                for (ArticuloManufacturadoDetalle detalle : detalles) {
                    ArticuloInsumo insumo = detalle.getArticuloInsumo();
                    // Cantidad necesaria de insumo por la cantidad de manufacturados del pedido
                    int cantidadInsumo = detalle.getCantidad() * cantidad;
                    // Descontar el stock actual
                    int stockDescontado = insumo.getStockActual() + cantidadInsumo;

                    insumo.setStockActual(stockDescontado); // Asignarle al insumo, el stock descontado
                }
            }
            return manufacturado; // Return the updated manufacturado
        } else {
            // Por si no encuentra el artículo o es de un tipo desconocido
            throw new RuntimeException("Artículo de tipo desconocido con id " + articulo.getId());
        }
    }

    @Override
    public List<Pedido> getPedidosFiltrados(String rol) {
        if (rol == null || rol.isEmpty()) {
            return pedidoRepository.findAll(); // If no role is provided, return all pedidos
        }
        switch (rol) {
            case "CAJERO":
                return pedidoRepository.findByEstadoIn(Arrays.asList(
                        Estado.PENDIENTE, Estado.TERMINADO, Estado.FACTURADO, Estado.EN_DELIVERY));
            case "COCINERO":
                return pedidoRepository.findByEstado(Estado.PREPARACION);
//            case "DELIVERY":
//                return pedidoRepository.findByEstado(Estado.EN_DELIVERY);
            case "ADMIN":
                return pedidoRepository.findAll(); // El admin puede ver todos los pedidos
            default:
                return new ArrayList<>();
        }
    }

    @Override
    public Pedido getPedidoById(Long pedidoId) {
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));
    }

}
