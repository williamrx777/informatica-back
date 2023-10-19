package br.com.informatica.services.impl;

import br.com.informatica.dtos.ComputadorDTO;
import br.com.informatica.mappers.ComputadorMapper;
import br.com.informatica.repositories.ComputadorRepository;
import br.com.informatica.services.ComputadorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ComputadorServiceImpl implements ComputadorService {


    private final ComputadorRepository computadorRepository;
    private final ComputadorMapper computadorMapper;

    public ComputadorServiceImpl(ComputadorRepository computadorRepository, ComputadorMapper computadorMapper) {
        this.computadorRepository = computadorRepository;
        this.computadorMapper = computadorMapper;
    }

    @Override
    public List<ComputadorDTO> listarTodos() {
        return computadorRepository.findAll().stream().map(computadorMapper::toDTO).toList();
    }

    @Override
    public ComputadorDTO postar(ComputadorDTO computadorDTO) {
        return computadorMapper.toDTO(computadorRepository.save(computadorMapper.toEntity(computadorDTO)));
    }

    @Override
    public ComputadorDTO buscarUm(UUID id) {
        return computadorRepository.findById(id).map(computadorMapper::toDTO).orElseThrow();
    }

    @Override
    public ComputadorDTO atualizar(UUID id, ComputadorDTO computadorDTO) {
        return computadorRepository.findById(id)
                .map(computador -> {
                    computador.setId(computadorDTO.id());
                    computador.setNome(computadorDTO.nome());
                    computador.setPreco(computadorDTO.preco());
                    computador.setCpu(computadorDTO.cpu());
                    return computadorMapper.toDTO(computadorRepository.save(computador));
                }).orElseThrow();
    }

    @Override
    public void deletar(UUID id) {
        computadorRepository.findById(id);
    }
}
