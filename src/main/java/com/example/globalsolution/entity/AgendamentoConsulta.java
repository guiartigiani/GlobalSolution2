package com.example.globalsolution.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "agendamento_consulta")
public class AgendamentoConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long agendamentoID;

    @ManyToOne
    @JoinColumn(name = "pacienteID")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medicoID")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "hospitalID")
    private HospitalClinica hospital;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraConsulta;

    private String status;
}
