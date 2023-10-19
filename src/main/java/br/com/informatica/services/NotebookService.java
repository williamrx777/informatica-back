package br.com.informatica.services;

import br.com.informatica.dtos.NotebookDTO;
import br.com.informatica.models.Notebook;

import java.util.List;
import java.util.UUID;

public interface NotebookService {

    List<NotebookDTO> listarTodos();

    NotebookDTO postar(NotebookDTO notebookDTO);

    NotebookDTO buscarUm(UUID id);

    NotebookDTO atualizar(UUID id, NotebookDTO notebookDTO);

    void deletar(UUID id);
}
