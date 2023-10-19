package br.com.informatica.services;

import br.com.informatica.dtos.ConsertoDTO;

import java.util.List;
import java.util.UUID;

public interface ConsertoService {

    List<ConsertoDTO> listarTodos();

    ConsertoDTO postar(ConsertoDTO consertoDTO);

    ConsertoDTO buscarUm(UUID id);

    ConsertoDTO atualizar(UUID id, ConsertoDTO consertoDTO);

    void deletar(UUID id);
}
