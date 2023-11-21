package com.example.globalsolution.controller;

import com.example.globalsolution.entity.Estado;
import com.example.globalsolution.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public ResponseEntity<Estado> createEstado(@RequestBody Estado estado) {
        return ResponseEntity.ok(estadoService.createEstado(estado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> updateEstado(@PathVariable Long id, @RequestBody Estado estado) {
        return ResponseEntity.ok(estadoService.updateEstado(id, estado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstado(@PathVariable Long id) {
        estadoService.deleteEstado(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Estado>> getAllEstados() {
        return ResponseEntity.ok(estadoService.getAllEstados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getEstadoById(@PathVariable Long id) {
        return ResponseEntity.ok(estadoService.getEstadoById(id));
    }
}
