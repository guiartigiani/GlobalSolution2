package com.example.globalsolution.repository;

import com.example.globalsolution.entity.ContatoEmergencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoEmergenciaRepository extends JpaRepository<ContatoEmergencia, Long> {

}
