package br.com.informatica.controllers;

import br.com.informatica.dtos.ConsertoDTO;
import br.com.informatica.services.ConsertoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/consertos")
public class ConsertoController {

    private final ConsertoService consertoService;

    public ConsertoController(ConsertoService consertoService) {
        this.consertoService = consertoService;
    }


    @GetMapping
    public ResponseEntity<List<ConsertoDTO>> listarTodos(){
        return ResponseEntity.ok(consertoService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<ConsertoDTO> postar(@RequestBody ConsertoDTO consertoDTO){
        consertoService.postar(consertoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(consertoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsertoDTO> buscarUm(@PathVariable UUID id){
        return ResponseEntity.ok(consertoService.buscarUm(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsertoDTO> atualizar(@PathVariable UUID id, @RequestBody ConsertoDTO consertoDTO){
        return ResponseEntity.ok(consertoService.atualizar(id, consertoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id){
        consertoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
