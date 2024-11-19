package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioClienteRepository extends BaseRepository<Usuario,Long> {

    Usuario findFirstByEmail(String email);
}
