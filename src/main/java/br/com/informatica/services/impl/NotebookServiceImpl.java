package br.com.informatica.services.impl;

import br.com.informatica.dtos.NotebookDTO;
import br.com.informatica.mappers.NotebookMapper;
import br.com.informatica.repositories.NotebookRepository;
import br.com.informatica.services.NotebookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NotebookServiceImpl implements NotebookService {

    private final NotebookRepository notebookRepository;
    private  final NotebookMapper notebookMapper;

    public NotebookServiceImpl(NotebookRepository notebookRepository, NotebookMapper notebookMapper) {
        this.notebookRepository = notebookRepository;
        this.notebookMapper = notebookMapper;
    }

    public List<NotebookDTO> listarTodos(){
        return notebookRepository.findAll().stream().map(notebookMapper::toDTO).toList();
    }

    @Override
    public NotebookDTO postar(NotebookDTO notebookDTO) {
        return notebookMapper.toDTO(notebookRepository.save(notebookMapper.toEntity(notebookDTO)));
    }

    @Override
    public NotebookDTO buscarUm(UUID id) {
        return notebookRepository.findById(id).map(notebookMapper::toDTO).orElseThrow();
    }

    @Override
    public NotebookDTO atualizar(UUID id, NotebookDTO notebookDTO) {
        return notebookRepository.findById(id)
                .map(notebook -> {
                    notebook.setId(notebookDTO.id());
                    notebook.setNome(notebookDTO.nome());
                    notebook.setPreco(notebookDTO.preco());
                    notebook.setMarca(notebookDTO.marca());
                    return notebookMapper.toDTO(notebookRepository.save(notebook));
                }).orElseThrow();
    }

    @Override
    public void deletar(UUID id) {
        notebookRepository.deleteById(id);
    }

}
