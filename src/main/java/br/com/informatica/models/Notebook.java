package br.com.informatica.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "notebooks")
@Data
public class Notebook {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(unique = true, length = 50)
    private String nome;
    private BigDecimal preco;
    @Enumerated
    private Marca marca;
}
