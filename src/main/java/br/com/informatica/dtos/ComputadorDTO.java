package br.com.informatica.dtos;

import br.com.informatica.models.CPU;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record ComputadorDTO(UUID id, @NotBlank String nome, @NotNull BigDecimal preco, CPU cpu) {
}
