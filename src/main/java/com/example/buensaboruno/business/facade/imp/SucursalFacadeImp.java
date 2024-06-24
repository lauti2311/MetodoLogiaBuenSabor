package com.example.buensaboruno.business.facade.imp;

import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.Sucursalfacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.business.service.Base.BaseServiceImpl;
import com.example.buensaboruno.business.service.SucursalService;
import com.example.buensaboruno.domain.dto.sucursal.SucursalFullDto;
import com.example.buensaboruno.domain.entities.Sucursal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class SucursalFacadeImp extends BaseFacadeImp<Sucursal, SucursalFullDto,Long> implements Sucursalfacade {
    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
    @Autowired
    SucursalService sucursalService;
    public SucursalFacadeImp(BaseService<Sucursal, Long> baseService, BaseMapper<Sucursal, SucursalFullDto> baseMapper) {
        super(baseService, baseMapper);
    }

    public List<SucursalFullDto> sucursalEmpresa(Long empresaId) {
        return this.sucursalService.sucursalEmpresa(empresaId);
    }


    @Override
    public SucursalFullDto createSucursal(SucursalFullDto dto) {
        var sucursal=baseMapper.toEntity(dto);
        var sucursalPersistida=sucursalService.guardarSucursal(sucursal);
        return baseMapper.toDTO(sucursalPersistida);
    }

    @Override
    public SucursalFullDto updateSucursal(Long id, SucursalFullDto dto) {

        var sucursal=baseMapper.toEntity(dto);

        var sucursalActualizada=sucursalService.actualizarSucursal(id,sucursal);
        return baseMapper.toDTO(sucursalActualizada);
    }

    @Override
    public ResponseEntity<List<Map<String, Object>>> getAllImagesBySucursalId(Long id) {
        return sucursalService.getAllImagesBySucursalId(id);
    }

    @Override
    public ResponseEntity<String> uploadImages(MultipartFile[] files, Long id) {
        return sucursalService.uploadImages(files,id);
    }

    @Override
    public ResponseEntity<String> deleteImage(String publicId, Long id) {
        return sucursalService.deleteImage(publicId, id);
    }
}
