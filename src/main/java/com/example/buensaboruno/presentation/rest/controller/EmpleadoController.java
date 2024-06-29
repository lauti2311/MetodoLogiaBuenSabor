package com.example.buensaboruno.presentation.rest.controller;


import com.example.buensaboruno.business.facade.imp.EmpleadoFacadeImp;
import com.example.buensaboruno.domain.dto.empleado.EmpleadoFullDto;
import com.example.buensaboruno.domain.entities.Empleado;
import com.example.buensaboruno.business.service.Imp.EmpleadoServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
@CrossOrigin("*")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoFullDto, Long, EmpleadoFacadeImp> {

    public EmpleadoController(EmpleadoFacadeImp facade) {super (facade); }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoFullDto> getById(@PathVariable Long id){
        return super.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoFullDto>> getAll() {
        return super.getAll();
    }

    @PostMapping()
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<EmpleadoFullDto> create(@RequestBody EmpleadoFullDto entity){
        return super.create(entity);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<EmpleadoFullDto> edit(@RequestBody EmpleadoFullDto entity, @PathVariable Long id){
        return super.edit(entity, id);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }
}
