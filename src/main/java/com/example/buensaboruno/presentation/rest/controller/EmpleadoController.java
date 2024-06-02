package com.example.buensaboruno.presentation.rest.controller;


import com.example.buensaboruno.business.facade.imp.EmpleadoFacadeImp;
import com.example.buensaboruno.domain.dto.empleado.EmpleadoFullDto;
import com.example.buensaboruno.domain.entities.Empleado;
import com.example.buensaboruno.business.service.Imp.EmpleadoServiceImpl;
import com.example.buensaboruno.presentation.rest.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleado")
@CrossOrigin("*")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoFullDto, Long, EmpleadoFacadeImp> {

    public EmpleadoController(EmpleadoFacadeImp facade) {super (facade); }

}
