package com.example.globalsolution.controller;

import com.example.globalsolution.entity.Medico;
import com.example.globalsolution.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<Medico> createMedico(@RequestBody Medico medico) {
        return ResponseEntity.ok(medicoService.createMedico(medico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> updateMedico(@PathVariable Long id, @RequestBody Medico medico) {
        return ResponseEntity.ok(medicoService.updateMedico(id, medico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable Long id) {
        medicoService.deleteMedico(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Medico>> getAllMedicos() {
        return ResponseEntity.ok(medicoService.getAllMedicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> getMedicoById(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.getMedicoById(id));
    }
}
