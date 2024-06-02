package com.example.buensaboruno.business.service.Imp;


import com.example.buensaboruno.business.service.Base.BaseServiceImpl;
import com.example.buensaboruno.business.service.CategoriaService;
import com.example.buensaboruno.domain.entities.Categoria;
import com.example.buensaboruno.domain.entities.Sucursal;
import com.example.buensaboruno.repositories.CategoriaRepository;
import com.example.buensaboruno.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Long> implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    SucursalRepository sucursalRepository;

    @Override
    public Categoria create(Categoria request) {
        // Guardar la instancia de Categoria en la base de datos para asegurarse de que esté gestionada por el EntityManager
        Categoria categoriaPersistida = categoriaRepository.save(request);

        Set<Sucursal> sucursales = categoriaPersistida.getSucursales();
        Set<Sucursal> sucursalesPersistidas = new HashSet<>();

        // Verificar y asociar sucursales existentes
        if (sucursales != null && !sucursales.isEmpty()) {
            for (Sucursal sucursal : sucursales) {
                // Verificar si la sucursal existe en la base de datos
                Optional<Sucursal> optionalSucursal = sucursalRepository.findById(sucursal.getId());
                if (optionalSucursal.isPresent()) {
                    Sucursal sucursalBd = optionalSucursal.get();
                    sucursalBd.getCategorias().add(categoriaPersistida); // Asociar la categoria a la sucursal
                    sucursalesPersistidas.add(sucursalBd);
                } else {
                    throw new RuntimeException("La sucursal con id " + sucursal.getId() + " no se ha encontrado");
                }
            }
            categoriaPersistida.setSucursales(sucursalesPersistidas); // Establecer las sucursales asociadas a la promoción
            categoriaRepository.save(categoriaPersistida); // Guardar la promoción actualizada con las sucursales asociadas
        }

        return categoriaPersistida;
    }

    @Override
    public Categoria update(Categoria request, Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La categoria con id " + id + " no se ha encontrado"));

        // Obtener todas las sucursales asociadas a la promoción
        Set<Sucursal> sucursalesActuales = categoria.getSucursales();

        // Eliminar las relaciones entre las sucursales y la promoción
        for (Sucursal sucursal : sucursalesActuales) {
            sucursal.getPromociones().remove(categoria);
            sucursalRepository.save(sucursal); // Guardar la sucursal actualizada
        }

        // Limpiar todas las sucursales asociadas a la promoción
        categoria.getSucursales().clear();

        // Agregar las nuevas sucursales proporcionadas en la solicitud
        Set<Sucursal> sucursales = request.getSucursales();
        Set<Sucursal> sucursalesPersistidas = new HashSet<>();

        if (sucursales != null && !sucursales.isEmpty()) {
            for (Sucursal sucursal : sucursales) {
                Sucursal sucursalBd = sucursalRepository.findById(sucursal.getId())
                        .orElseThrow(() -> new RuntimeException("La sucursal con id " + sucursal.getId() + " no se ha encontrado"));
                sucursalBd.getCategorias().add(categoria);
                sucursalesPersistidas.add(sucursalBd);
            }
            categoria.setSucursales(sucursalesPersistidas);
        }

        return super.update(request, id);
    }
}

