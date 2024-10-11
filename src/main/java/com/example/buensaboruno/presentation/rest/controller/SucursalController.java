package com.example.buensaboruno.presentation.rest.controller;


import com.example.buensaboruno.business.facade.Sucursalfacade;
import com.example.buensaboruno.business.facade.imp.SucursalFacadeImp;
import com.example.buensaboruno.business.service.Base.BaseServiceImpl;
import com.example.buensaboruno.domain.dto.sucursal.SucursalFullDto;
import com.example.buensaboruno.domain.entities.Sucursal;
import com.example.buensaboruno.business.service.Imp.SucursalServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/sucursales")
public class SucursalController extends BaseControllerImpl<Sucursal, SucursalFullDto,Long, SucursalFacadeImp> {
    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
    public SucursalController(SucursalFacadeImp facade) {
        super(facade);
    }

    @Autowired
    private Sucursalfacade sucursalfacade;

    @GetMapping("/empresas/{idEmpresa}")
    public ResponseEntity<List<SucursalFullDto>> sucursalEmpresa(@PathVariable Long idEmpresa) {
        List<SucursalFullDto> sucursales = sucursalfacade.sucursalEmpresa(idEmpresa);
        if (sucursales != null && !sucursales.isEmpty()) {
            return ResponseEntity.ok(sucursales);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @Override
    @PostMapping()
    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<SucursalFullDto> create(@RequestBody SucursalFullDto dto) {
        return ResponseEntity.ok().body(facade.createSucursal(dto));
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<SucursalFullDto> edit(@RequestBody SucursalFullDto dto, @PathVariable Long id){
        logger.info("Editing Sucursal "+id);
        logger.info("Editing Sucursal "+dto.getId());
        return ResponseEntity.ok().body(facade.updateSucursal(id, dto));
    }
    @PostMapping("/uploads")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<String> uploadImages(
            @RequestParam(value = "uploads", required = true) MultipartFile[] files,
            @RequestParam(value = "id", required = true) Long idArticulo) {
        try {
            return facade.uploadImages(files, idArticulo); // Llama al método del servicio para subir imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }

    // Método POST para eliminar imágenes por su publicId y Long
    @PostMapping("/deleteImg")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<String> deleteById(
            @RequestParam(value = "publicId", required = true) String publicId,
            @RequestParam(value = "id", required = true) Long id) {
        try {
            return facade.deleteImage(publicId, id); // Llama al método del servicio para eliminar la imagen
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid UUID format"); // Respuesta HTTP 400 si el UUID no es válido
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred"); // Respuesta HTTP 500 si ocurre un error inesperado
        }
    }

    // Método GET para obtener todas las imágenes almacenadas
    @GetMapping("/getAllImagesBySucursalId/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id) {
        try {
            return facade.getAllImagesBySucursalId(id); // Llama al método del servicio para obtener todas las imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }
}
