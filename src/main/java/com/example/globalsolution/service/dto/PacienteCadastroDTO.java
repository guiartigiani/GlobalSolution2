package com.example.globalsolution.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class PacienteCadastroDTO {
    // Dados do paciente
    private String nome;
    private Date dataNascimento;
    private String sexo;

    // Dados do endereço
    private String rua;
    private String numero;
    private String complemento;
    private String cep;

    // Dados da cidade e estado
    private String nomeCidade;
    private String nomeEstado;

    // Getters e setters
}
