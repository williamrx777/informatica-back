package br.com.informatica.controllers;

import br.com.informatica.dtos.ProdutoDTO;
import br.com.informatica.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarTodos(){
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> postar(@RequestBody @Valid ProdutoDTO produtoDTO){
            return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.postar(produtoDTO));

        }


    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarUm(@PathVariable UUID id){
        return ResponseEntity.ok(produtoService.buscarUm(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizar(@PathVariable UUID id, @RequestBody @Valid ProdutoDTO produtoDTO){
        return ResponseEntity.ok(produtoService.atualizar(id, produtoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
