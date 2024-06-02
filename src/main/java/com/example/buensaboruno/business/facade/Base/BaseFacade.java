package com.example.buensaboruno.business.facade.Base;


import com.example.buensaboruno.domain.dto.BaseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseFacade <D extends BaseDto, ID extends Serializable>{
    public D createNew(D request);
    public D getById(Long id);
    public List<D> getAll();
    public void deleteById(Long id);
    public D update(D request, Long id);
}