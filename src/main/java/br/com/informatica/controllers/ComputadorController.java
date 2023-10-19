package br.com.informatica.controllers;

import br.com.informatica.dtos.ComputadorDTO;
import br.com.informatica.services.ComputadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/computadores")
public class ComputadorController {

    private final ComputadorService computadorService;

    public ComputadorController(ComputadorService computadorService) {
        this.computadorService = computadorService;
    }

    @GetMapping
    public ResponseEntity<List<ComputadorDTO>> listarTodos(){
        return ResponseEntity.ok(computadorService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<ComputadorDTO> postar(@RequestBody ComputadorDTO computadorDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(computadorService.postar(computadorDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComputadorDTO> buscarUm(@PathVariable UUID id){
        return ResponseEntity.ok(computadorService.buscarUm(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComputadorDTO> atualizar(@PathVariable UUID id, @RequestBody ComputadorDTO computadorDTO){
        return ResponseEntity.ok(computadorService.atualizar(id, computadorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ComputadorDTO> deletar(@PathVariable UUID id){
        computadorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
