package com.example.buensaboruno.business.facade.imp;

import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.business.facade.CategoriaFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.dto.categoria.CategoriaCreateDto;
import com.example.buensaboruno.domain.entities.Categoria;
import org.springframework.stereotype.Service;

@Service
public class CategoriaFacadeImp extends BaseFacadeImp<Categoria, CategoriaCreateDto, Long> implements CategoriaFacade {

    public CategoriaFacadeImp(BaseService<Categoria, Long> baseService, BaseMapper<Categoria, CategoriaCreateDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Override
    public CategoriaCreateDto create(CategoriaCreateDto dto) {
        Categoria categoria = baseMapper.toEntity(dto); // Convierte DTO a entidad

        // Asignar el ID de la categoría padre si está presente en el DTO
        if (dto.getCategoriaPadreId() != null) {
            Categoria categoriaPadre = baseService.getById(dto.getCategoriaPadreId());
            categoria.setCategoriaPadre(categoriaPadre);
        } else {
            categoria.setCategoriaPadre(null); // Asegura que se establece como null si no hay categoriaPadreId
        }

        // Guardar la entidad
        Categoria createdEntity = baseService.create(categoria);

        // Puedes convertir de nuevo a DTO si es necesario antes de devolverlo
        return baseMapper.toDTO(createdEntity); // Convierte entidad a DTO
    }
}
