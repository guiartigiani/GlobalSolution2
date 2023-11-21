package com.example.globalsolution.controller;

import com.example.globalsolution.entity.HistoricoClinico;
import com.example.globalsolution.service.HistoricoClinicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historicoClinicos")
public class HistoricoClinicoController {

    @Autowired
    private HistoricoClinicoService historicoClinicoService;

    @PostMapping
    public ResponseEntity<HistoricoClinico> createHistoricoClinico(@RequestBody HistoricoClinico historicoClinico) {
        return ResponseEntity.ok(historicoClinicoService.createHistoricoClinico(historicoClinico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoricoClinico> updateHistoricoClinico(@PathVariable Long id, @RequestBody HistoricoClinico historicoClinico) {
        return ResponseEntity.ok(historicoClinicoService.updateHistoricoClinico(id, historicoClinico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistoricoClinico(@PathVariable Long id) {
        historicoClinicoService.deleteHistoricoClinico(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<HistoricoClinico>> getAllHistoricoClinicos() {
        return ResponseEntity.ok(historicoClinicoService.getAllHistoricoClinicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoClinico> getHistoricoClinicoById(@PathVariable Long id) {
        return ResponseEntity.ok(historicoClinicoService.getHistoricoClinicoById(id));
    }
}
