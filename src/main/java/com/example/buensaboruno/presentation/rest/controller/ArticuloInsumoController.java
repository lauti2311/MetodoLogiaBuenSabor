package com.example.buensaboruno.presentation.rest.controller;

import com.example.buensaboruno.business.facade.imp.ArticuloInsumoFacadeImp;
import com.example.buensaboruno.domain.dto.articuloInsumo.ArticuloInsumoFullDto;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.business.service.Imp.ArticuloInsumoServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/articuloInsumo")
@CrossOrigin("*")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoFullDto, Long, ArticuloInsumoFacadeImp> {
    public ArticuloInsumoController(ArticuloInsumoFacadeImp facade) { super(facade); }
    // Método POST para subir imágenes
    @PostMapping("/uploads")
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
    @GetMapping("/getAllImagesByInsumoId/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id) {
        try {
            return facade.getAllImagesByInsumoId(id); // Llama al método del servicio para obtener todas las imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }
}