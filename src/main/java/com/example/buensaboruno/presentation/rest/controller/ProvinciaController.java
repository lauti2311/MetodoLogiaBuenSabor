package com.example.buensaboruno.presentation.rest.controller;

import com.example.buensaboruno.business.facade.imp.ProvinciaFacadeImp;
import com.example.buensaboruno.domain.dto.provincia.ProvinciaFullDto;
import com.example.buensaboruno.domain.entities.Provincia;
import com.example.buensaboruno.business.service.Imp.ProvinciaServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/provincias")
public class ProvinciaController extends BaseControllerImpl<Provincia, ProvinciaFullDto,Long, ProvinciaFacadeImp> {
    public ProvinciaController(ProvinciaFacadeImp facade) {
        super(facade);
    }

    private static final Logger logger = LoggerFactory.getLogger(ProvinciaController.class);

    @GetMapping("findByPais/{idPais}")
    public ResponseEntity<List<ProvinciaFullDto>> getByProvincia(@PathVariable Long idPais) {
        logger.info("INICIO GET BY PROVINCIA");
        return ResponseEntity.ok(facade.findByPaisId(idPais));
    }
}