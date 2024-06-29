package com.example.buensaboruno.presentation.rest.controller;


import com.example.buensaboruno.business.facade.imp.CategoriaFacadeImp;
import com.example.buensaboruno.domain.dto.categoria.CategoriaCreateDto;
import com.example.buensaboruno.domain.entities.Categoria;
import com.example.buensaboruno.business.service.Imp.CategoriaServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaCreateDto, Long, CategoriaFacadeImp> {

    public CategoriaController(CategoriaFacadeImp facade) {super (facade); }
    @GetMapping("/sucursal/{idSucursal}")
    public List<CategoriaCreateDto> getCategoriasPorSucursal(@PathVariable Long idSucursal) {
        return this.facade.categoriaSucursal(idSucursal);
    }
    @GetMapping("/sucursal/insumo/{idSucursal}")
    public List<CategoriaCreateDto> getCategoriasInsumoPorSucursal(@PathVariable Long idSucursal) {
        return this.facade.categoriaInsumoSucursal(idSucursal);
    }
    @GetMapping("/sucursal/manufacturado/{idSucursal}")
    public List<CategoriaCreateDto> getCategoriasManufacturadoPorSucursal(@PathVariable Long idSucursal) {
        return this.facade.categoriaManufacturadoSucursal(idSucursal);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaCreateDto> getById(@PathVariable Long id){
        return super.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaCreateDto>> getAll() {
        return super.getAll();
    }

    @PostMapping()
    //@PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<CategoriaCreateDto> create(@RequestBody CategoriaCreateDto entity){
        return super.create(entity);
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<CategoriaCreateDto> edit(@RequestBody CategoriaCreateDto entity, @PathVariable Long id){
        return super.edit(entity, id);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }
}

