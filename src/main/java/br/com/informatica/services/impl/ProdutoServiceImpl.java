package br.com.informatica.services.impl;

import br.com.informatica.dtos.ProdutoDTO;
import br.com.informatica.mappers.ProdutoMapper;
import br.com.informatica.repositories.ProdutoRepository;
import br.com.informatica.services.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;
    public ProdutoServiceImpl(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    @Override
    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.findAll().stream().map(produtoMapper::toDTO).toList();
    }

    @Override
    public ProdutoDTO postar(ProdutoDTO produtoDTO) {
        return produtoMapper.toDTO(produtoRepository.save(produtoMapper.toEntity(produtoDTO)));
    }

    @Override
    public ProdutoDTO buscarUm(UUID id) {
        return produtoRepository.findById(id).map(produtoMapper::toDTO).orElseThrow();
    }

    @Override
    public ProdutoDTO atualizar(UUID id, ProdutoDTO produtoDTO) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setId(produtoDTO.id());
                    produto.setNome(produtoDTO.nome());
                    produto.setPreco(produtoDTO.preco());
                    produto.setImagem(produtoDTO.imagem());
                    produto.setTipo(produtoDTO.tipo());
                    return produtoMapper.toDTO(produtoRepository.save(produto));
                }).orElseThrow();
    }

    @Override
    public void deletar(UUID id) {
        produtoRepository.deleteById(id);
    }
}
