package com.example.buensaboruno.business.facade.imp;


import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.EmpresaFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.mapper.EmpresaMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.business.service.EmpresaService;
import com.example.buensaboruno.domain.dto.empresa.EmpresaCreateDto;
import com.example.buensaboruno.domain.dto.empresa.EmpresaFullDto;
import com.example.buensaboruno.domain.entities.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class EmpresaFacadeImpl extends BaseFacadeImp<Empresa, EmpresaCreateDto,Long> implements EmpresaFacade {

    public EmpresaFacadeImpl(BaseService<Empresa, Long> baseService, BaseMapper<Empresa, EmpresaCreateDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    EmpresaMapper empresaMapper;


    @Autowired
    EmpresaService empresaService;
    @Override
    public EmpresaFullDto addSucursal(Long idEmpresa, Long idSucursal) {
        return empresaMapper.toLargeDto(empresaService.addSucursal(idEmpresa, idSucursal));
    }

    @Override
    public ResponseEntity<List<Map<String, Object>>> getAllImagesByEmpresaId(Long id) {
        return empresaService.getAllImagesByEmpresaId(id);
    }

    @Override
    public ResponseEntity<String> uploadImages(MultipartFile[] files, Long id) {
        return empresaService.uploadImages(files,id);
    }

    @Override
    public ResponseEntity<String> deleteImage(String publicId, Long id) {
        return empresaService.deleteImage(publicId, id);
    }
}
