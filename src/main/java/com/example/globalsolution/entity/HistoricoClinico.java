package com.example.globalsolution.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "historico_clinico")
public class HistoricoClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long historicoID;

    @ManyToOne
    @JoinColumn(name = "pacienteID")
    private Paciente paciente;

    @NotBlank(message = "A data é obrigatório")
    @Temporal(TemporalType.DATE)
    private Date dataConsulta;

    private String descricao;

    @NotBlank(message = "O médico responsavel é obrigatório")
    private String medicoResponsavel;

    @ManyToOne
    @JoinColumn(name = "medicoID")
    private Medico medico;

}
