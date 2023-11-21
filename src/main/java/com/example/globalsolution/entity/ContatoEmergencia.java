package com.example.globalsolution.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "contato_emergencia")
public class ContatoEmergencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contatoID;

    @ManyToOne
    @JoinColumn(name = "pacienteID")
    private Paciente paciente;

    @NotBlank(message = "O nome é obrigatório")
    private String nomeContato;

    @NotBlank(message = "A Relação é obrigatória")
    private String relacao;

    @NotBlank(message = "O Telefone é obrigatório")
    private String telefone;

}
