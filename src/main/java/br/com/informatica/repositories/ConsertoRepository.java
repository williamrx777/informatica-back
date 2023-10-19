package br.com.informatica.repositories;

import br.com.informatica.models.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsertoRepository extends JpaRepository<Conserto, UUID> {
}
