package br.com.informatica.services;

import br.com.informatica.dtos.ComputadorDTO;

import java.util.List;
import java.util.UUID;

public interface ComputadorService {

    List<ComputadorDTO> listarTodos();

    ComputadorDTO postar(ComputadorDTO computadorDTO);

    ComputadorDTO buscarUm(UUID id);

    ComputadorDTO atualizar(UUID id, ComputadorDTO computadorDTO);

    void deletar(UUID id);


}
