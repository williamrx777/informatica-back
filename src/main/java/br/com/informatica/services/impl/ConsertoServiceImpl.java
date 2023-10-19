package br.com.informatica.services.impl;

import br.com.informatica.dtos.ConsertoDTO;
import br.com.informatica.mappers.ConsertoMapper;
import br.com.informatica.repositories.ConsertoRepository;
import br.com.informatica.services.ConsertoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsertoServiceImpl implements ConsertoService {

    private final ConsertoRepository consertoRepository;
    private final ConsertoMapper consertoMapper;

    public ConsertoServiceImpl(ConsertoRepository consertoRepository, ConsertoMapper consertoMapper) {
        this.consertoRepository = consertoRepository;
        this.consertoMapper = consertoMapper;
    }

    @Override
    public List<ConsertoDTO> listarTodos() {
        return consertoRepository.findAll().stream().map(consertoMapper::toDTO).toList();
    }

    @Override
    public ConsertoDTO postar(ConsertoDTO consertoDTO) {
        return consertoMapper.toDTO(consertoRepository.save(consertoMapper.toEntity(consertoDTO)));
    }

    @Override
    public ConsertoDTO buscarUm(UUID id) {
        return consertoRepository.findById(id).map(consertoMapper::toDTO).orElseThrow();
    }

    @Override
    public ConsertoDTO atualizar(UUID id, ConsertoDTO consertoDTO) {
        return consertoRepository.findById(id)
                .map(conserto -> {
                    conserto.setId(consertoDTO.id());
                    conserto.setNome(consertoDTO.nome());
                    conserto.setData(consertoDTO.data());
                    return consertoMapper.toDTO(consertoRepository.save(conserto));
                }).orElseThrow();
    }

    @Override
    public void deletar(UUID id) {
        consertoRepository.deleteById(id);
    }
}
