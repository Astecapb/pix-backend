package br.com.robson.pix_backend.repositories;

import br.com.robson.pix_backend.models.Bilhete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BilheteRepository extends JpaRepository<Bilhete, Long> {
}
