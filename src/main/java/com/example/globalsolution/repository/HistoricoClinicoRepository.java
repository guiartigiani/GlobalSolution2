package com.example.globalsolution.repository;

import com.example.globalsolution.entity.HistoricoClinico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoClinicoRepository extends JpaRepository<HistoricoClinico, Long> {
}
