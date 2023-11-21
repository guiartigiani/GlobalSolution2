package com.example.globalsolution.service;

import com.example.globalsolution.entity.HistoricoClinico;
import com.example.globalsolution.exception.HistoricoClinicoNotFoundException;
import com.example.globalsolution.repository.HistoricoClinicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoClinicoService {

    @Autowired
    private HistoricoClinicoRepository historicoClinicoRepository;

    public HistoricoClinico createHistoricoClinico(HistoricoClinico historicoClinico) {
        return historicoClinicoRepository.save(historicoClinico);
    }

    public HistoricoClinico updateHistoricoClinico(Long id, HistoricoClinico updatedHistoricoClinico) {
        HistoricoClinico historicoClinico = historicoClinicoRepository.findById(id)
                .orElseThrow(() -> new HistoricoClinicoNotFoundException("Clinical history not found with ID: " + id));
        historicoClinico.setPaciente(updatedHistoricoClinico.getPaciente());
        historicoClinico.setDataConsulta(updatedHistoricoClinico.getDataConsulta());
        historicoClinico.setDescricao(updatedHistoricoClinico.getDescricao());
        historicoClinico.setMedicoResponsavel(updatedHistoricoClinico.getMedicoResponsavel());
        historicoClinico.setMedico(updatedHistoricoClinico.getMedico());
        return historicoClinicoRepository.save(historicoClinico);
    }

    public void deleteHistoricoClinico(Long id) {
        historicoClinicoRepository.deleteById(id);
    }

    public List<HistoricoClinico> getAllHistoricoClinicos() {
        return historicoClinicoRepository.findAll();
    }

    public HistoricoClinico getHistoricoClinicoById(Long id) {
        return historicoClinicoRepository.findById(id)
                .orElseThrow(() -> new HistoricoClinicoNotFoundException("Clinical history not found with ID: " + id));
    }
}
