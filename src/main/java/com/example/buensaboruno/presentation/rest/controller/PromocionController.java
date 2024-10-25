package com.example.buensaboruno.presentation.rest.controller;

import com.example.buensaboruno.business.facade.PromocionFacade;
import com.example.buensaboruno.business.facade.imp.PromocionFacadeImp;
import com.example.buensaboruno.domain.dto.promocion.PromocionFullDto;
import com.example.buensaboruno.domain.entities.Promocion;
import com.example.buensaboruno.business.service.Imp.PromocionServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/promociones")
public class PromocionController extends BaseControllerImpl<Promocion, PromocionFullDto, Long, PromocionFacadeImp> {

    public PromocionController(PromocionFacadeImp facade) {super (facade); }

    @Autowired
    private PromocionFacade promocionFacade;

    @GetMapping("/sucursal/{idSucursal}")
    public ResponseEntity<List<PromocionFullDto>> promocionSucursal(@PathVariable Long idSucursal) {
        List<PromocionFullDto> promociones = promocionFacade.promocionSucursal(idSucursal);
        if (promociones != null && !promociones.isEmpty()) {
            return ResponseEntity.ok(promociones);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<PromocionFullDto> getById(@PathVariable Long id){
        return super.getById(id);
    }


    @GetMapping
    public ResponseEntity<List<PromocionFullDto>> getAll() {
        List<PromocionFullDto> promociones = super.getAll().getBody();

        if (promociones != null) {
            LocalDate today = LocalDate.now();
            LocalTime now = LocalTime.now();

            // Filtrar promociones que estén activas hoy
            List<PromocionFullDto> promocionesDelDia = promociones.stream()
                    .filter(p -> {
                        LocalDate fechaDesde = LocalDate.parse(p.getFechaDesde(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        LocalDate fechaHasta = LocalDate.parse(p.getFechaHasta(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        LocalTime horaDesde = LocalTime.parse(p.getHoraDesde());
                        LocalTime horaHasta = LocalTime.parse(p.getHoraHasta());

                        // Condición 1: El día de hoy debe estar dentro del rango de fechas
                        boolean fechaValida = !fechaDesde.isAfter(today) && !fechaHasta.isBefore(today);

                        // Condición 2: Si hoy es la fecha desde, entonces verifica que la hora actual esté después de la hora de inicio
                        boolean horaValidaHoy = (fechaDesde.isEqual(today) && now.isAfter(horaDesde))
                                || (fechaHasta.isEqual(today) && now.isBefore(horaHasta))
                                || (!fechaDesde.isEqual(today) && !fechaHasta.isEqual(today));

                        return fechaValida && horaValidaHoy;
                    })
                    .collect(Collectors.toList());

            return ResponseEntity.ok(promocionesDelDia);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping()
    //@PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<PromocionFullDto> create(@RequestBody PromocionFullDto entity){
        return super.create(entity);
    }

    @PutMapping("/{id}")
   // @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<PromocionFullDto> edit(@RequestBody PromocionFullDto entity, @PathVariable Long id){
        return super.edit(entity, id);
    }

    @DeleteMapping("/{id}")
   // @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
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
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }

    // Método POST para eliminar imágenes por su publicId y Long
    @PostMapping("/deleteImg")
    //@PreAuthorize("hasAnyAuthority('ADMIN', 'SUPERADMIN')")
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
    @GetMapping("/getAllImagesByPromocionId/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id) {
        try {
            return facade.getAllImagesByPromocionId(id); // Llama al método del servicio para obtener todas las imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }
}