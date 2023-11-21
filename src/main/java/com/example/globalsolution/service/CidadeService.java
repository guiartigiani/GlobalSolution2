package com.example.globalsolution.service;

import com.example.globalsolution.entity.Cidade;
import com.example.globalsolution.exception.CidadeNotFoundException;
import com.example.globalsolution.exception.ContatoEmergencialNotFoundException;
import com.example.globalsolution.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade createCidade(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public Cidade updateCidade(Long id, Cidade updatedCidade) {
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new CidadeNotFoundException("City not found with ID: " + id));
        cidade.setNomeCidade(updatedCidade.getNomeCidade());
        cidade.setEstado(updatedCidade.getEstado());
        return cidadeRepository.save(cidade);
    }

    public void deleteCidade(Long id) {
        cidadeRepository.deleteById(id);
    }

    public List<Cidade> getAllCidades() {
        return cidadeRepository.findAll();
    }

    public Cidade getCidadeById(Long id) {
        return cidadeRepository.findById(id)
                .orElseThrow(() -> new CidadeNotFoundException("City not found with ID: " + id));
    }
}
