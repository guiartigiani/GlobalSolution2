package com.example.globalsolution.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospitalClinicaDTO {
    private String nomeHospital;
    private String telefone;

    // Informações de Endereço
    private String rua;
    private String numero;
    private String complemento;
    private String cep;

    // Informações de Localização
    private double latitude;
    private double longitude;

    // Informações de Cidade e Estado
    private String nomeCidade;
    private String nomeEstado;
}
