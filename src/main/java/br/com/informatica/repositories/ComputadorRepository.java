package br.com.informatica.repositories;

import br.com.informatica.models.Computador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComputadorRepository extends JpaRepository<Computador, UUID> {
}
