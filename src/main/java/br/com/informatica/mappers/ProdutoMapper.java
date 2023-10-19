package br.com.informatica.mappers;

import br.com.informatica.dtos.ProdutoDTO;
import br.com.informatica.models.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoDTO toDTO(Produto produto){
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getPreco(), produto.getImagem(), produto.getTipo());
    }

    public Produto toEntity(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setId(produtoDTO.id());
        produto.setNome(produtoDTO.nome());
        produto.setPreco(produtoDTO.preco());
        produto.setImagem(produtoDTO.imagem());
        produto.setTipo(produtoDTO.tipo());
        return produto;
    }

}
