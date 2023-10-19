package br.com.informatica.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "produtos")
@Data
public class Produto {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(unique = true)
    private String nome;
    private BigDecimal preco;
    private String imagem;
    @Enumerated
    private Tipo tipo;
}

