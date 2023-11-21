package com.example.globalsolution.repository;

import com.example.globalsolution.entity.AgendamentoConsulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoConsultaRepository extends JpaRepository<AgendamentoConsulta, Long> {

}
