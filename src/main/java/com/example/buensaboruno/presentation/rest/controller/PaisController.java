package com.example.buensaboruno.presentation.rest.controller;


import com.example.buensaboruno.business.facade.imp.PaisFacadeImp;
import com.example.buensaboruno.domain.dto.pais.PaisFullDto;
import com.example.buensaboruno.domain.entities.Pais;
import com.example.buensaboruno.business.service.Imp.PaisServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/paises")
public class PaisController extends BaseControllerImpl<Pais, PaisFullDto,Long, PaisFacadeImp> {

    public PaisController(PaisFacadeImp facade) {
        super(facade);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PaisFullDto> getById(@PathVariable Long id){
        return super.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<PaisFullDto>> getAll() {
        return super.getAll();
    }

    @PostMapping()
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<PaisFullDto> create(@RequestBody PaisFullDto entity){
        return super.create(entity);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<PaisFullDto> edit(@RequestBody PaisFullDto entity, @PathVariable Long id){
        return super.edit(entity, id);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }
}