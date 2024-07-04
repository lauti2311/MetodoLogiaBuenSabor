package com.example.buensaboruno.business.facade.Base;

import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.service.Base.BaseService;
import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.entities.Base;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseFacadeImp<E extends Base, D extends BaseDto, ID extends Serializable> implements BaseFacade<D, ID> {

    protected BaseService<E,ID> baseService;
    protected BaseMapper<E,D> baseMapper;

    public BaseFacadeImp(BaseService<E,ID> baseService, BaseMapper<E,D> baseMapper) {
        this.baseService = baseService;
        this.baseMapper = baseMapper;
    }

    @Override
    public D create(D request){
        var entityToCreate = baseMapper.toEntity(request);
        var entityCreated = baseService.create(entityToCreate);
        return baseMapper.toDTO(entityCreated);
    }

    @Override
    public D getById(ID id){
        var entity = baseService.getById(id);
        return baseMapper.toDTO(entity);
    }

    @Override
    public List<D> getAll() {
        var entities = baseService.getAll();
        return entities.stream().map(baseMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteById(ID id) {
        baseService.deleteById(id);
    }

    @Override
    public D update(D request, ID id) {
        var entityToUpdate = baseMapper.toEntity(request);
        var entityUpdated = baseService.update(entityToUpdate, id);
        return baseMapper.toDTO(entityUpdated);
    }
}
