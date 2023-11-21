package com.example.globalsolution.service;

import com.example.globalsolution.entity.Medico;
import com.example.globalsolution.exception.MedicoNotFoundException;
import com.example.globalsolution.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico createMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico updateMedico(Long id, Medico updatedMedico) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new MedicoNotFoundException("Doctor not found with ID: " + id));
        medico.setNomeMedico(updatedMedico.getNomeMedico());
        medico.setEspecialidade(updatedMedico.getEspecialidade());
        medico.setCrm(updatedMedico.getCrm());
        medico.setHospital(updatedMedico.getHospital());
        return medicoRepository.save(medico);
    }

    public void deleteMedico(Long id) {
        medicoRepository.deleteById(id);
    }

    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    public Medico getMedicoById(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new MedicoNotFoundException("Doctor not found with ID: " + id));
    }
}
