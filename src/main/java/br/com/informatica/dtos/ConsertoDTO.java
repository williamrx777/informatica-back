package br.com.informatica.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record ConsertoDTO(UUID id, String nome, LocalDate data) {
}
