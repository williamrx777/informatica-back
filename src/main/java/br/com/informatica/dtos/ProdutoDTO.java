package br.com.informatica.dtos;

import br.com.informatica.models.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;


import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoDTO(UUID id, @NotBlank String nome, @NotNull BigDecimal preco, String imagem, Tipo tipo) {
}
