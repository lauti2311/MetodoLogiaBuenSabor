package com.example.buensaboruno.presentation.rest.controller;


import com.example.buensaboruno.business.facade.imp.CategoriaFacadeImp;
import com.example.buensaboruno.domain.dto.categoria.CategoriaCreateDto;
import com.example.buensaboruno.domain.entities.Categoria;
import com.example.buensaboruno.business.service.Imp.CategoriaServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaCreateDto, Long, CategoriaFacadeImp> {

    public CategoriaController(CategoriaFacadeImp facade) {super (facade); }
}

