package com.example.buensaboruno.presentation.rest.controller;


import com.example.buensaboruno.business.facade.imp.ClienteFacadeImp;
import com.example.buensaboruno.domain.dto.cliente.ClienteFullDto;
import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.business.service.Imp.ClienteServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteFullDto, Long, ClienteFacadeImp> {

    public ClienteController(ClienteFacadeImp facade) {super (facade); }

//    @GetMapping("email/{email}")
//    public Cliente getClientByEmail(@PathVariable String email) {
//        return this.facade.findByEmail(email);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteFullDto> getById(@PathVariable Long id){
        return super.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<ClienteFullDto>> getAll() {
        return super.getAll();
    }

    @PostMapping()
    //@PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<ClienteFullDto> create(@RequestBody ClienteFullDto entity){
        return super.create(entity);
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<ClienteFullDto> edit(@RequestBody ClienteFullDto entity, @PathVariable Long id){
        return super.edit(entity, id);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }
}

