package com.example.buensaboruno.presentation.rest.controller;

import com.example.buensaboruno.business.facade.ArticuloManufacturadoFacade;
import com.example.buensaboruno.business.facade.imp.ArticuloManufacturadoFacadeImp;
import com.example.buensaboruno.domain.dto.articuloManufacturado.ArticuloManufacturadoFullDto;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/articuloManufacturado")
@CrossOrigin("*")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoFullDto, Long, ArticuloManufacturadoFacadeImp> {

    @Autowired
    private ArticuloManufacturadoFacade articuloManufacturadoFacade;

    public ArticuloManufacturadoController(ArticuloManufacturadoFacadeImp facade) {
        super(facade);
    }

    @GetMapping("/sucursal/{idSucursal}")
    public ResponseEntity<List<ArticuloManufacturadoFullDto>> manufacturados(@PathVariable Long idSucursal) {
        List<ArticuloManufacturadoFullDto> manufacturados = articuloManufacturadoFacade.manufacturados(idSucursal);
        if (manufacturados != null && !manufacturados.isEmpty()) {
            return ResponseEntity.ok(manufacturados);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticuloManufacturadoFullDto> getById(@PathVariable Long id) {
        return super.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<ArticuloManufacturadoFullDto>> getAll() {
        return super.getAll();
    }

    @PostMapping
    public ResponseEntity<ArticuloManufacturadoFullDto> create(@RequestBody ArticuloManufacturadoFullDto entity) {
        return super.create(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticuloManufacturadoFullDto> edit(@RequestBody ArticuloManufacturadoFullDto entity, @PathVariable Long id) {
        ArticuloManufacturadoFullDto updatedArticulo = articuloManufacturadoFacade.update(entity, id);
        if (updatedArticulo != null) {
            return ResponseEntity.ok(updatedArticulo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return super.deleteById(id);
    }

    @PostMapping("/uploads")
   // @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<String> uploadImages(
            @RequestParam(value = "uploads", required = true) MultipartFile[] files,
            @RequestParam(value = "id", required = true) Long idArticulo) {
        try {
            return facade.uploadImages(files, idArticulo); // Llama al método del servicio para subir imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error uploading images");
        }
    }

    @PostMapping("/deleteImg")
    //@PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<String> deleteById(
            @RequestParam(value = "publicId", required = true) String publicId,
            @RequestParam(value = "id", required = true) Long id) {
        try {
            return facade.deleteImage(publicId, id); // Llama al método del servicio para eliminar la imagen
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid UUID format");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred");
        }
    }

    @GetMapping("/getAllImagesByArticuloManufacturadoId/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id) {
        try {
            return facade.getAllImagesByArticuloManufacturadoId(id); // Llama al método del servicio para obtener todas las imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error retrieving images");
        }
    }
}
