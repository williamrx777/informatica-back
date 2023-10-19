package br.com.informatica.mappers;

import br.com.informatica.dtos.ConsertoDTO;
import br.com.informatica.models.Conserto;
import org.springframework.stereotype.Component;

@Component
public class ConsertoMapper {

    public ConsertoDTO toDTO(Conserto conserto){
        return new ConsertoDTO(conserto.getId(), conserto.getNome(), conserto.getData());
    }

    public Conserto toEntity(ConsertoDTO consertoDTO){
        var conserto = new Conserto();
        conserto.setId(consertoDTO.id());
        conserto.setNome(consertoDTO.nome());
        conserto.setData(consertoDTO.data());
        return conserto;
    }

}
