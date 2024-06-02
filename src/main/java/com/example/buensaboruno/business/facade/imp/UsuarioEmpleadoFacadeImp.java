package com.example.buensaboruno.business.facade.imp;


import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.UsuarioEmpleadoFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.dto.usuarioEmpleado.UsuarioEmpleadoFullDto;
import com.example.buensaboruno.domain.entities.UsuarioEmpleado;
import org.springframework.stereotype.Service;

@Service
public class UsuarioEmpleadoFacadeImp extends BaseFacadeImp<UsuarioEmpleado, UsuarioEmpleadoFullDto, Long> implements UsuarioEmpleadoFacade {


    public UsuarioEmpleadoFacadeImp(BaseService<UsuarioEmpleado, Long> baseService, BaseMapper<UsuarioEmpleado, UsuarioEmpleadoFullDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
