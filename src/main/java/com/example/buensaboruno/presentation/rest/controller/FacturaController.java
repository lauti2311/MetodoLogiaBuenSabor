package com.example.buensaboruno.presentation.rest.controller;


import com.example.buensaboruno.business.facade.imp.FacturaFacadeImp;
import com.example.buensaboruno.domain.dto.factura.FacturaFullDto;
import com.example.buensaboruno.domain.entities.Factura;
import com.example.buensaboruno.business.service.Imp.FacturaServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/facturas")
public class FacturaController extends BaseControllerImpl<Factura, FacturaFullDto, Long, FacturaFacadeImp> {

    public FacturaController(FacturaFacadeImp facade) {super (facade); }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaFullDto> getById(@PathVariable Long id){
        return super.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<FacturaFullDto>> getAll() {
        return super.getAll();
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<FacturaFullDto> create(@RequestBody FacturaFullDto entity){
        return super.create(entity);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<FacturaFullDto> edit(@RequestBody FacturaFullDto entity, @PathVariable Long id){
        return super.edit(entity, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', SUPERADMIN)")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }

    @PostMapping("/crear/{pedidoId}")
    @PreAuthorize("hasAnyAuthority('CAJERO', 'ADMIN', 'SUPERADMIN')")
    public ResponseEntity<Factura> crearFactura(@PathVariable Long pedidoId) {
        Factura factura = this.facade.crearFactura(pedidoId);
        return ResponseEntity.ok(factura);
    }
}
