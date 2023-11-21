package com.example.globalsolution.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "alocacao_medico")
public class AlocacaoMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long alocacaoID;

    @ManyToOne
    @JoinColumn(name = "medicoID")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "hospitalID")
    private HospitalClinica hospital;

    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    private Date dataFim;
}

