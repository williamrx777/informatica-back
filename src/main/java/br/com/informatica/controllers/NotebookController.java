package br.com.informatica.controllers;

import br.com.informatica.dtos.NotebookDTO;
import br.com.informatica.services.NotebookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/notebooks")
public class NotebookController {

    private final NotebookService notebookService;

    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    @GetMapping
    public ResponseEntity<List<NotebookDTO>> listarTodos(){
        return ResponseEntity.ok(notebookService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<NotebookDTO> postar(@RequestBody NotebookDTO notebookDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(notebookService.postar(notebookDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotebookDTO> buscarUm(@PathVariable UUID id){
        return ResponseEntity.ok(notebookService.buscarUm(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotebookDTO> atualizar(@PathVariable UUID id, @RequestBody NotebookDTO notebookDTO){
        return ResponseEntity.ok(notebookService.atualizar(id, notebookDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id){
        notebookService.deletar(id);
        return ResponseEntity.noContent().build();
    }



}
