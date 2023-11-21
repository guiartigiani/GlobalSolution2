package com.example.globalsolution.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cidadeId;

    @Column(name = "nome_cidade")
    private String nomeCidade;

    @ManyToOne
    @JoinColumn(name = "estadoId")
    private Estado estado;

    public Cidade() {

    }

    public Cidade(String nomeCidade, Estado estado) {
        this.nomeCidade = nomeCidade;
        this.estado = estado;
    }
}
