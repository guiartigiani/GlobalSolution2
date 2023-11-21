package com.example.globalsolution.controller;

import com.example.globalsolution.entity.AlocacaoMedico;
import com.example.globalsolution.service.AlocacaoMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alocacaoMedicos")
public class AlocacaoMedicoController {

    @Autowired
    private AlocacaoMedicoService alocacaoMedicoService;

    @PostMapping
    public ResponseEntity<AlocacaoMedico> createAlocacaoMedico(@RequestBody AlocacaoMedico alocacaoMedico) {
        return ResponseEntity.ok(alocacaoMedicoService.createAlocacaoMedico(alocacaoMedico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlocacaoMedico> updateAlocacaoMedico(@PathVariable Long id, @RequestBody AlocacaoMedico alocacaoMedico) {
        return ResponseEntity.ok(alocacaoMedicoService.updateAlocacaoMedico(id, alocacaoMedico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlocacaoMedico(@PathVariable Long id) {
        alocacaoMedicoService.deleteAlocacaoMedico(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<AlocacaoMedico>> getAllAlocacaoMedicos() {
        return ResponseEntity.ok(alocacaoMedicoService.getAllAlocacaoMedicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlocacaoMedico> getAlocacaoMedicoById(@PathVariable Long id) {
        return ResponseEntity.ok(alocacaoMedicoService.getAlocacaoMedicoById(id));
    }
}
