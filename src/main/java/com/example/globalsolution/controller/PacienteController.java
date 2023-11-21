package com.example.globalsolution.controller;

import com.example.globalsolution.entity.Paciente;
import com.example.globalsolution.service.PacienteService;
import com.example.globalsolution.service.dto.PacienteCadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody PacienteCadastroDTO pacienteDTO) {
        Paciente novoPaciente = pacienteService.createPaciente(pacienteDTO);
        return ResponseEntity.ok(novoPaciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody PacienteCadastroDTO pacienteDTO) {
        return ResponseEntity.ok(pacienteService.updatePaciente(id, pacienteDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        return ResponseEntity.ok(pacienteService.getAllPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.getPacienteById(id));
    }
}