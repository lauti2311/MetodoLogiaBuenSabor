package com.example.buensaboruno.presentation.rest.base;

import com.example.buensaboruno.business.facade.Base.BaseFacadeImp;
import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.entities.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Controller
public abstract class BaseControllerImpl<E extends Base, D extends BaseDto, ID extends Serializable, F extends BaseFacadeImp<E, D, ID>> implements BaseController<D, ID> {

    private static final Logger logger = LoggerFactory.getLogger(BaseControllerImpl.class);
    protected F facade;

    public BaseControllerImpl(F facade) {
        this.facade = facade;
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> getById(@PathVariable ID id) {
        logger.info("INICIO GET BY ID {}", id);
        return ResponseEntity.ok(facade.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<D>> getAll() {
        logger.info("INICIO GET ALL");
        return ResponseEntity.ok(facade.getAll());
    }

    @PostMapping()
    public ResponseEntity<D> create(@RequestBody D entity) {
        logger.info("INICIO CREATE {}", entity.getClass());
        return ResponseEntity.ok(facade.createNew(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> edit(@RequestBody D entity, @PathVariable ID id) {
        logger.info("INICIO EDIT {}", entity.getClass());
        return ResponseEntity.ok(facade.update(entity, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable ID id) {
        logger.info("INICIO DELETE BY ID");
        facade.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
