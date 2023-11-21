package com.example.globalsolution.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO  )
    private Long medicoID;

    @NotBlank(message = "O nome é obrigatório")
    private String nomeMedico;

    @NotBlank(message = "A especialidade é obrigatório")
    private String especialidade;

    @NotBlank(message = "O CRM é obrigatório")
    private String crm;

    @ManyToOne
    @JoinColumn(name = "hospitalID")
    private HospitalClinica hospital;

}
