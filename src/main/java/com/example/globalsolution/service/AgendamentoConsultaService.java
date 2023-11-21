package com.example.globalsolution.service;

import com.example.globalsolution.entity.AgendamentoConsulta;
import com.example.globalsolution.exception.AgendamentoConsultaNotFoundException;
import com.example.globalsolution.exception.AlocacaoMedicoNotFoundException;
import com.example.globalsolution.repository.AgendamentoConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoConsultaService {

    @Autowired
    private AgendamentoConsultaRepository agendamentoConsultaRepository;

    public AgendamentoConsulta createAgendamentoConsulta(AgendamentoConsulta agendamentoConsulta) {
        return agendamentoConsultaRepository.save(agendamentoConsulta);
    }

    public AgendamentoConsulta updateAgendamentoConsulta(Long id, AgendamentoConsulta updatedAgendamentoConsulta) {
        AgendamentoConsulta agendamentoConsulta = agendamentoConsultaRepository.findById(id)
                .orElseThrow(() -> new AgendamentoConsultaNotFoundException("Appointment scheduling not found with ID: " + id));
        agendamentoConsulta.setPaciente(updatedAgendamentoConsulta.getPaciente());
        agendamentoConsulta.setMedico(updatedAgendamentoConsulta.getMedico());
        agendamentoConsulta.setHospital(updatedAgendamentoConsulta.getHospital());
        agendamentoConsulta.setDataHoraConsulta(updatedAgendamentoConsulta.getDataHoraConsulta());
        agendamentoConsulta.setStatus(updatedAgendamentoConsulta.getStatus());
        return agendamentoConsultaRepository.save(agendamentoConsulta);
    }

    public void deleteAgendamentoConsulta(Long id) {
        agendamentoConsultaRepository.deleteById(id);
    }

    public List<AgendamentoConsulta> getAllAgendamentoConsultas() {
        return agendamentoConsultaRepository.findAll();
    }

    public AgendamentoConsulta getAgendamentoConsultaById(Long id) {
        return agendamentoConsultaRepository.findById(id)
                .orElseThrow(() -> new AgendamentoConsultaNotFoundException("Appointment scheduling not found with ID: " + id));
    }
}
