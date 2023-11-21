package com.example.globalsolution.repository;

import com.example.globalsolution.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Optional<Cidade> findByNomeCidade(String nomeCidade); // Ajuste para corresponder ao nome do campo
}
