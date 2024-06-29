package com.example.buensaboruno.presentation.rest.controller;

import com.example.buensaboruno.business.facade.imp.LocalidadFacadeImp;
import com.example.buensaboruno.domain.dto.localidad.LocalidadFullDto;
import com.example.buensaboruno.domain.entities.Localidad;
import com.example.buensaboruno.business.service.Imp.LocalidadServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadFullDto, Long, LocalidadFacadeImp> {

    public LocalidadController(LocalidadFacadeImp facade) {
        super(facade);
    }
    private static final Logger logger = LoggerFactory.getLogger(LocalidadController.class);

    @GetMapping("findByProvincia/{idProvincia}")
    public ResponseEntity<List<LocalidadFullDto>> getByProvincia(@PathVariable Long idProvincia) {
        logger.info("INICIO GET BY PROVINCIA");
        return ResponseEntity.ok(facade.findByProvinciaId(idProvincia));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalidadFullDto> getById(@PathVariable Long id){
        return super.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<LocalidadFullDto>> getAll() {
        return super.getAll();
    }

    @PostMapping()
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<LocalidadFullDto> create(@RequestBody LocalidadFullDto entity){
        return super.create(entity);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<LocalidadFullDto> edit(@RequestBody LocalidadFullDto entity, @PathVariable Long id){
        return super.edit(entity, id);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }
}
