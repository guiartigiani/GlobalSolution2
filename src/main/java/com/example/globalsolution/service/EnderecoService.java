package com.example.globalsolution.service;

import com.example.globalsolution.entity.Endereco;
import com.example.globalsolution.exception.EnderecoNotFoundException;
import com.example.globalsolution.exception.EstadoNotFoundException;
import com.example.globalsolution.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco createEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco updateEndereco(Long id, Endereco updatedEndereco) {
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new EnderecoNotFoundException("Address not found with ID: " + id));
        endereco.setRua(updatedEndereco.getRua());
        endereco.setNumero(updatedEndereco.getNumero());
        endereco.setComplemento(updatedEndereco.getComplemento());
        endereco.setCep(updatedEndereco.getCep());
        endereco.setCidade(updatedEndereco.getCidade());
        return enderecoRepository.save(endereco);
    }

    public void deleteEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }

    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco getEnderecoById(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new EnderecoNotFoundException("Address not found with ID: " + id));
    }
}
