package br.com.informatica.dtos;

import br.com.informatica.models.Marca;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record NotebookDTO(UUID id, @NotBlank String nome, @NotNull BigDecimal preco, Marca marca) {
}
