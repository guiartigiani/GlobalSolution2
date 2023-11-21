package com.example.globalsolution.service;

import com.example.globalsolution.entity.Cidade;
import com.example.globalsolution.entity.Endereco;
import com.example.globalsolution.entity.Estado;
import com.example.globalsolution.entity.Paciente;
import com.example.globalsolution.exception.PacienteNotFoundException;
import com.example.globalsolution.repository.CidadeRepository;
import com.example.globalsolution.repository.EnderecoRepository;
import com.example.globalsolution.repository.EstadoRepository;
import com.example.globalsolution.repository.PacienteRepository;
import com.example.globalsolution.service.dto.PacienteCadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public Paciente createPaciente(PacienteCadastroDTO pacienteDTO) {
        // Criar entidades e salvar no repositório
        Endereco endereco = new Endereco();
        endereco.setRua(pacienteDTO.getRua());
        endereco.setNumero(pacienteDTO.getNumero());
        endereco.setComplemento(pacienteDTO.getComplemento());
        endereco.setCep(pacienteDTO.getCep());

        // Buscar ou criar Cidade e Estado baseado nos nomes
        Cidade cidade = cidadeRepository.findByNomeCidade(pacienteDTO.getNomeCidade())
                .orElseGet(() -> {
                    Estado estado = estadoRepository.findByNomeEstado(pacienteDTO.getNomeEstado())
                            .orElse(new Estado(pacienteDTO.getNomeEstado()));
                    estadoRepository.save(estado);
                    return new Cidade(pacienteDTO.getNomeCidade(), estado);
                });
        cidadeRepository.save(cidade);

        endereco.setCidade(cidade);

        // Salvar o endereço
        enderecoRepository.save(endereco);

        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDTO.getNome());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setSexo(pacienteDTO.getSexo());
        paciente.setEndereco(endereco);

        return pacienteRepository.save(paciente);
    }

    public Paciente updatePaciente(Long id, PacienteCadastroDTO pacienteDTO) {
        Paciente pacienteExistente = pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException("Patient not found with ID: " + id));

        // Atualizar propriedades básicas do paciente
        pacienteExistente.setNome(pacienteDTO.getNome());
        pacienteExistente.setDataNascimento(pacienteDTO.getDataNascimento());
        pacienteExistente.setSexo(pacienteDTO.getSexo());

        // Atualizar endereço
        Endereco endereco = pacienteExistente.getEndereco();
        if (endereco == null) {
            endereco = new Endereco();
        }
        endereco.setRua(pacienteDTO.getRua());
        endereco.setNumero(pacienteDTO.getNumero());
        endereco.setComplemento(pacienteDTO.getComplemento());
        endereco.setCep(pacienteDTO.getCep());

        // Atualizar Cidade e Estado
        Cidade cidade = cidadeRepository.findByNomeCidade(pacienteDTO.getNomeCidade())
                .orElseGet(() -> {
                    Estado estado = estadoRepository.findByNomeEstado(pacienteDTO.getNomeEstado())
                            .orElse(new Estado(pacienteDTO.getNomeEstado()));
                    estadoRepository.save(estado);
                    return new Cidade(pacienteDTO.getNomeCidade(), estado);
                });
        cidadeRepository.save(cidade);

        endereco.setCidade(cidade);
        enderecoRepository.save(endereco);

        pacienteExistente.setEndereco(endereco);

        return pacienteRepository.save(pacienteExistente);
    }

    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente getPacienteById(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException("Patient not found with ID: " + id));
    }
}

