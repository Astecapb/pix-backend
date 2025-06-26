package br.com.robson.pix_backend.repositories;

import br.com.robson.pix_backend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
}
