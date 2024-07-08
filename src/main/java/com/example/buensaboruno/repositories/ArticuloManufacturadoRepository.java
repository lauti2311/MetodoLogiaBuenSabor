package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.domain.entities.Base;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long> {

    @Query("SELECT DISTINCT p FROM ArticuloManufacturado p " +
            "LEFT JOIN FETCH p.imagenes i " +
            "WHERE p.sucursal.id = :idSucursal AND p.eliminado = false AND (i IS NULL OR i.eliminado = false)")
    List<ArticuloManufacturado> manufacturados(@Param("idSucursal") Long idSucursal);
}
