package com.example.globalsolution.controller;

import com.example.globalsolution.entity.HospitalClinica;
import com.example.globalsolution.service.HospitalClinicaService;
import com.example.globalsolution.service.dto.HospitalClinicaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitalclinicas")
public class HospitalClinicaController {

    @Autowired
    private HospitalClinicaService hospitalClinicaService;

    @PostMapping
    public ResponseEntity<HospitalClinica> createHospitalClinica(@RequestBody HospitalClinicaDTO hospitalClinicaDTO) {
        return ResponseEntity.ok(hospitalClinicaService.createHospitalClinica(hospitalClinicaDTO));
    }

    @GetMapping("/localizacao")
    public ResponseEntity<List<HospitalClinica>> getAllClinicasComLocalizacao() {
        List<HospitalClinica> clinicas = hospitalClinicaService.getAllHospitalClinicas();
        // Aqui, você pode adicionar lógica para filtrar ou ajustar dados, se necessário
        return ResponseEntity.ok(clinicas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HospitalClinica> updateHospitalClinica(@PathVariable Long id, @RequestBody HospitalClinica hospitalClinica) {
        return ResponseEntity.ok(hospitalClinicaService.updateHospitalClinica(id, hospitalClinica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHospitalClinica(@PathVariable Long id) {
        hospitalClinicaService.deleteHospitalClinica(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<HospitalClinica>> getAllHospitalClinicas() {
        return ResponseEntity.ok(hospitalClinicaService.getAllHospitalClinicas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalClinica> getHospitalClinicaById(@PathVariable Long id) {
        return ResponseEntity.ok(hospitalClinicaService.getHospitalClinicaById(id));
    }
}
