package com.example.globalsolution.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long enderecoId;

    private String rua;

    private String numero;

    private String complemento;

    private String cep;

    @ManyToOne
    @JoinColumn(name = "cidadeId")
    private Cidade cidade;
}
