package com.example.globalsolution.repository;

import com.example.globalsolution.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Optional<Estado> findByNomeEstado(String nomeEstado); // Ajuste para corresponder ao nome do campo
}
