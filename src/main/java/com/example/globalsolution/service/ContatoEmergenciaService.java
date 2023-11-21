package com.example.globalsolution.service;

import com.example.globalsolution.entity.ContatoEmergencia;
import com.example.globalsolution.exception.ContatoEmergencialNotFoundException;
import com.example.globalsolution.exception.EnderecoNotFoundException;
import com.example.globalsolution.repository.ContatoEmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoEmergenciaService {

    @Autowired
    private ContatoEmergenciaRepository contatoEmergenciaRepository;

    public ContatoEmergencia createContatoEmergencia(ContatoEmergencia contatoEmergencia) {
        return contatoEmergenciaRepository.save(contatoEmergencia);
    }

    public ContatoEmergencia updateContatoEmergencia(Long id, ContatoEmergencia updatedContatoEmergencia) {
        ContatoEmergencia contatoEmergencia = contatoEmergenciaRepository.findById(id)
                .orElseThrow(() -> new ContatoEmergencialNotFoundException("Emergency contact not found with ID: " + id));
        contatoEmergencia.setPaciente(updatedContatoEmergencia.getPaciente());
        contatoEmergencia.setNomeContato(updatedContatoEmergencia.getNomeContato());
        contatoEmergencia.setRelacao(updatedContatoEmergencia.getRelacao());
        contatoEmergencia.setTelefone(updatedContatoEmergencia.getTelefone());
        return contatoEmergenciaRepository.save(contatoEmergencia);
    }

    public void deleteContatoEmergencia(Long id) {
        contatoEmergenciaRepository.deleteById(id);
    }

    public List<ContatoEmergencia> getAllContatoEmergencias() {
        return contatoEmergenciaRepository.findAll();
    }

    public ContatoEmergencia getContatoEmergenciaById(Long id) {
        return contatoEmergenciaRepository.findById(id)
                .orElseThrow(() -> new ContatoEmergencialNotFoundException("Emergency contact not found with ID: " + id));
    }
}