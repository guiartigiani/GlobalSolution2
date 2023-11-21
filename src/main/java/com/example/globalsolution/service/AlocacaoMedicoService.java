package com.example.globalsolution.service;

import com.example.globalsolution.entity.AlocacaoMedico;
import com.example.globalsolution.exception.AlocacaoMedicoNotFoundException;
import com.example.globalsolution.exception.CidadeNotFoundException;
import com.example.globalsolution.repository.AlocacaoMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlocacaoMedicoService {

    @Autowired
    private AlocacaoMedicoRepository alocacaoMedicoRepository;

    public AlocacaoMedico createAlocacaoMedico(AlocacaoMedico alocacaoMedico) {
        return alocacaoMedicoRepository.save(alocacaoMedico);
    }

    public AlocacaoMedico updateAlocacaoMedico(Long id, AlocacaoMedico updatedAlocacaoMedico) {
        AlocacaoMedico alocacaoMedico = alocacaoMedicoRepository.findById(id)
                .orElseThrow(() -> new AlocacaoMedicoNotFoundException("Medical allocation not found with ID: " + id));
        alocacaoMedico.setMedico(updatedAlocacaoMedico.getMedico());
        alocacaoMedico.setHospital(updatedAlocacaoMedico.getHospital());
        alocacaoMedico.setDataInicio(updatedAlocacaoMedico.getDataInicio());
        alocacaoMedico.setDataFim(updatedAlocacaoMedico.getDataFim());
        return alocacaoMedicoRepository.save(alocacaoMedico);
    }

    public void deleteAlocacaoMedico(Long id) {
        alocacaoMedicoRepository.deleteById(id);
    }

    public List<AlocacaoMedico> getAllAlocacaoMedicos() {
        return alocacaoMedicoRepository.findAll();
    }

    public AlocacaoMedico getAlocacaoMedicoById(Long id) {
        return alocacaoMedicoRepository.findById(id)
                .orElseThrow(() -> new AlocacaoMedicoNotFoundException("Medical allocation not found with ID: " + id));
    }
}

