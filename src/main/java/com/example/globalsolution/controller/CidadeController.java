package com.example.globalsolution.controller;

import com.example.globalsolution.entity.Cidade;
import com.example.globalsolution.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Cidade> createCidade(@RequestBody Cidade cidade) {
        return ResponseEntity.ok(cidadeService.createCidade(cidade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> updateCidade(@PathVariable Long id, @RequestBody Cidade cidade) {
        return ResponseEntity.ok(cidadeService.updateCidade(id, cidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCidade(@PathVariable Long id) {
        cidadeService.deleteCidade(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> getAllCidades() {
        return ResponseEntity.ok(cidadeService.getAllCidades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> getCidadeById(@PathVariable Long id) {
        return ResponseEntity.ok(cidadeService.getCidadeById(id));
    }
}
