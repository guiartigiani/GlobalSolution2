package com.example.globalsolution.controller;

import com.example.globalsolution.entity.AgendamentoConsulta;
import com.example.globalsolution.service.AgendamentoConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentoConsultas")
public class AgendamentoConsultaController {

    @Autowired
    private AgendamentoConsultaService agendamentoConsultaService;

    @PostMapping
    public ResponseEntity<AgendamentoConsulta> createAgendamentoConsulta(@RequestBody AgendamentoConsulta agendamentoConsulta) {
        return ResponseEntity.ok(agendamentoConsultaService.createAgendamentoConsulta(agendamentoConsulta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoConsulta> updateAgendamentoConsulta(@PathVariable Long id, @RequestBody AgendamentoConsulta agendamentoConsulta) {
        return ResponseEntity.ok(agendamentoConsultaService.updateAgendamentoConsulta(id, agendamentoConsulta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgendamentoConsulta(@PathVariable Long id) {
        agendamentoConsultaService.deleteAgendamentoConsulta(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoConsulta>> getAllAgendamentoConsultas() {
        return ResponseEntity.ok(agendamentoConsultaService.getAllAgendamentoConsultas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoConsulta> getAgendamentoConsultaById(@PathVariable Long id) {
        return ResponseEntity.ok(agendamentoConsultaService.getAgendamentoConsultaById(id));
    }
}
