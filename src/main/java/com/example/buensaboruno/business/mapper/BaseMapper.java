package com.example.buensaboruno.business.mapper;



import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.entities.Base;

import java.util.List;

public interface BaseMapper<T extends Base,D extends BaseDto>{
    public D toDTO(T source);
    public T toEntity(D source);
    public List<D> toDTOsList(List<T> source);
}
