package com.example.buensaboruno.presentation.rest.controller;

import com.example.buensaboruno.business.facade.imp.UsuarioFacadeImp;
import com.example.buensaboruno.domain.dto.usuarioCliente.UsuarioClienteFullDto;
import com.example.buensaboruno.domain.entities.Usuario;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioClienteFullDto, Long, UsuarioFacadeImp> {

    public UsuarioController(UsuarioFacadeImp facade) {super (facade); }

    @GetMapping("role/{email}")
    @CrossOrigin("*")
   // @PreAuthorize("isAuthenticated()")
    public Usuario getUsuarioPorEmail(@PathVariable String email) {
        return this.facade.obtenerUsuarioClientePorEmail(email);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioClienteFullDto> getById(@PathVariable Long id){
        return super.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioClienteFullDto>> getAll() {
        return super.getAll();
    }

    @PostMapping()
    //@PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<UsuarioClienteFullDto> create(@RequestBody UsuarioClienteFullDto entity){
        return super.create(entity);
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<UsuarioClienteFullDto> edit(@RequestBody UsuarioClienteFullDto entity, @PathVariable Long id){
        return super.edit(entity, id);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }

}