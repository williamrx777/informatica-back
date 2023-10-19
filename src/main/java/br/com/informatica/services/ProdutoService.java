package br.com.informatica.services;

import br.com.informatica.dtos.ProdutoDTO;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    List<ProdutoDTO> listarTodos();

    ProdutoDTO postar(ProdutoDTO produtoDTO);

    ProdutoDTO buscarUm(UUID id);

    ProdutoDTO atualizar(UUID id, ProdutoDTO produtoDTO);

    void deletar(UUID id);

}
