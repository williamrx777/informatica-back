package br.com.informatica.mappers;

import br.com.informatica.dtos.NotebookDTO;
import br.com.informatica.models.Notebook;
import org.springframework.stereotype.Component;

@Component
public class NotebookMapper {

    public NotebookDTO toDTO(Notebook notebook){
        return new NotebookDTO(notebook.getId(), notebook.getNome(), notebook.getPreco(),notebook.getMarca());
    }

    public Notebook toEntity(NotebookDTO notebookDTO){
        var notebook = new Notebook();
        notebook.setId(notebookDTO.id());
        notebook.setNome(notebookDTO.nome());
        notebook.setPreco(notebookDTO.preco());
        notebook.setMarca(notebookDTO.marca());
        return notebook;
    }


}
