package com.example.globalsolution.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "hospital_clinica")
public class HospitalClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO  )
    private Long hospitalID;

    @NotBlank(message = "O nome do hospital é obrigatório")
    private String nomeHospital;

    @ManyToOne
    @JoinColumn(name = "enderecoID")
    private Endereco endereco;

    private String telefone;

    private double latitude;

    private double longitude;
}
