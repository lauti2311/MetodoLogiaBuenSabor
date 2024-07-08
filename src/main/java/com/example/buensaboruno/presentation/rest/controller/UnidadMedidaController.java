package com.example.buensaboruno.presentation.rest.controller;

import com.example.buensaboruno.business.facade.imp.UnidadMedidaFacadeImp;
import com.example.buensaboruno.domain.dto.unidadMedida.UnidadMedidaFullDto;
import com.example.buensaboruno.domain.entities.UnidadMedida;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidadMedida")
@CrossOrigin("*")
public class UnidadMedidaController extends BaseControllerImpl<UnidadMedida, UnidadMedidaFullDto, Long, UnidadMedidaFacadeImp> {
     public UnidadMedidaController(UnidadMedidaFacadeImp facade) {
         super(facade);
     }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadMedidaFullDto> getById(@PathVariable Long id){
        return super.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<UnidadMedidaFullDto>> getAll() {
        return super.getAll();
    }

    @PostMapping()
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<UnidadMedidaFullDto> create(@RequestBody UnidadMedidaFullDto entity){
        return super.create(entity);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<UnidadMedidaFullDto> edit(@RequestBody UnidadMedidaFullDto entity, @PathVariable Long id){
        return super.edit(entity, id);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }
}
