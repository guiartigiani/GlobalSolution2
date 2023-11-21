package com.example.globalsolution.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pacienteId;

    private String nome;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    private String sexo;

    @ManyToOne
    @JoinColumn(name = "enderecoId")
    private Endereco endereco;
}
