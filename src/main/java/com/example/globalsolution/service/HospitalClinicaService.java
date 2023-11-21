package com.example.globalsolution.service;

import com.example.globalsolution.entity.Cidade;
import com.example.globalsolution.entity.Endereco;
import com.example.globalsolution.entity.Estado;
import com.example.globalsolution.entity.HospitalClinica;
import com.example.globalsolution.exception.HospitalClinicaNotFoundException;
import com.example.globalsolution.repository.CidadeRepository;
import com.example.globalsolution.repository.EnderecoRepository;
import com.example.globalsolution.repository.EstadoRepository;
import com.example.globalsolution.repository.HospitalClinicaRepository;
import com.example.globalsolution.service.dto.HospitalClinicaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalClinicaService {

    @Autowired
    private HospitalClinicaRepository hospitalClinicaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;


    public HospitalClinica createHospitalClinica(HospitalClinicaDTO hospitalClinicaDTO) {
        // Criar entidade Endereco
        Endereco endereco = new Endereco();
        endereco.setRua(hospitalClinicaDTO.getRua());
        endereco.setNumero(hospitalClinicaDTO.getNumero());
        endereco.setComplemento(hospitalClinicaDTO.getComplemento());
        endereco.setCep(hospitalClinicaDTO.getCep());

        // Buscar ou criar Cidade e Estado baseado nos nomes
        Cidade cidade = cidadeRepository.findByNomeCidade(hospitalClinicaDTO.getNomeCidade())
                .orElseGet(() -> {
                    Estado estado = estadoRepository.findByNomeEstado(hospitalClinicaDTO.getNomeEstado())
                            .orElse(new Estado(hospitalClinicaDTO.getNomeEstado()));
                    estadoRepository.save(estado);
                    return new Cidade(hospitalClinicaDTO.getNomeCidade(), estado);
                });
        cidadeRepository.save(cidade);

        endereco.setCidade(cidade);

        // Salvar o endereço
        enderecoRepository.save(endereco);

        // Criar entidade HospitalClinica
        HospitalClinica hospitalClinica = new HospitalClinica();
        hospitalClinica.setNomeHospital(hospitalClinicaDTO.getNomeHospital());
        hospitalClinica.setTelefone(hospitalClinicaDTO.getTelefone());
        hospitalClinica.setEndereco(endereco);
        hospitalClinica.setLatitude(hospitalClinicaDTO.getLatitude());
        hospitalClinica.setLongitude(hospitalClinicaDTO.getLongitude());

        // Aqui você pode adicionar a lógica para tratar a latitude e a longitude, se aplicável

        return hospitalClinicaRepository.save(hospitalClinica);
    }

    public HospitalClinica updateHospitalClinica(Long id, HospitalClinica updatedHospitalClinica) {
        HospitalClinica hospitalClinica = hospitalClinicaRepository.findById(id)
                .orElseThrow(() -> new HospitalClinicaNotFoundException("Hospital/Clinic not found with ID: " + id));
        hospitalClinica.setNomeHospital(updatedHospitalClinica.getNomeHospital());
        hospitalClinica.setEndereco(updatedHospitalClinica.getEndereco());
        hospitalClinica.setTelefone(updatedHospitalClinica.getTelefone());
        return hospitalClinicaRepository.save(hospitalClinica);
    }

    public void deleteHospitalClinica(Long id) {
        hospitalClinicaRepository.deleteById(id);
    }

    public List<HospitalClinica> getAllHospitalClinicas() {
        return hospitalClinicaRepository.findAll();
    }

    public HospitalClinica getHospitalClinicaById(Long id) {
        return hospitalClinicaRepository.findById(id)
                .orElseThrow(() -> new HospitalClinicaNotFoundException("Hospital/Clinic not found with ID: " + id));
    }
}
