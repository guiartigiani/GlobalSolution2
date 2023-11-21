package com.example.globalsolution.controller;

import com.example.globalsolution.entity.ContatoEmergencia;
import com.example.globalsolution.service.ContatoEmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatoEmergencias")
public class ContatoEmergenciaController {

    @Autowired
    private ContatoEmergenciaService contatoEmergenciaService;

    @PostMapping
    public ResponseEntity<ContatoEmergencia> createContatoEmergencia(@RequestBody ContatoEmergencia contatoEmergencia) {
        return ResponseEntity.ok(contatoEmergenciaService.createContatoEmergencia(contatoEmergencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoEmergencia> updateContatoEmergencia(@PathVariable Long id, @RequestBody ContatoEmergencia contatoEmergencia) {
        return ResponseEntity.ok(contatoEmergenciaService.updateContatoEmergencia(id, contatoEmergencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContatoEmergencia(@PathVariable Long id) {
        contatoEmergenciaService.deleteContatoEmergencia(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ContatoEmergencia>> getAllContatoEmergencias() {
        return ResponseEntity.ok(contatoEmergenciaService.getAllContatoEmergencias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoEmergencia> getContatoEmergenciaById(@PathVariable Long id) {
        return ResponseEntity.ok(contatoEmergenciaService.getContatoEmergenciaById(id));
    }
}
