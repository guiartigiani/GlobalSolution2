package com.example.globalsolution.controller;

import com.example.globalsolution.entity.Endereco;
import com.example.globalsolution.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.createEndereco(endereco));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.updateEndereco(id, endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
        enderecoService.deleteEndereco(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEnderecos() {
        return ResponseEntity.ok(enderecoService.getAllEnderecos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.getEnderecoById(id));
    }
}

