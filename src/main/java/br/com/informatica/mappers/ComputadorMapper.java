package br.com.informatica.mappers;

import br.com.informatica.dtos.ComputadorDTO;
import br.com.informatica.models.Computador;
import org.springframework.stereotype.Component;

@Component
public class ComputadorMapper {

    public ComputadorDTO toDTO(Computador computador){
        return new ComputadorDTO(computador.getId(), computador.getNome(), computador.getPreco(), computador.getCpu());
    }

    public Computador toEntity(ComputadorDTO computadorDTO){
        var computador = new Computador();
        computador.setId(computadorDTO.id());
        computador.setNome(computadorDTO.nome());
        computador.setPreco(computadorDTO.preco());
        computador.setCpu(computadorDTO.cpu());
        return computador;
    }

}
