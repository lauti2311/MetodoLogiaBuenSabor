package com.example.buensaboruno.business.facade.imp;


import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.EmpleadoFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.dto.empleado.EmpleadoFullDto;
import com.example.buensaboruno.domain.entities.Empleado;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoFacadeImp extends BaseFacadeImp<Empleado, EmpleadoFullDto, Long> implements EmpleadoFacade {
    public EmpleadoFacadeImp(BaseService<Empleado, Long> baseService, BaseMapper<Empleado, EmpleadoFullDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
