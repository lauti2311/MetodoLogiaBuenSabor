package com.example.buensaboruno.business.facade.Base;

import java.io.Serializable;
import java.util.List;

public interface BaseFacade<D, ID extends Serializable> {
    D create(D dto);
    D getById(ID id);
    List<D> getAll();
    void deleteById(ID id);
    D update(D dto, ID id);
}
