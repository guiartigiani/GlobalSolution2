package com.example.globalsolution.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estado")
@Getter
@Setter
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long estadoID;

    private String nomeEstado;

    public Estado() {

    }

    public Estado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }
}
