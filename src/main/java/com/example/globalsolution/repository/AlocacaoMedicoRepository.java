package com.example.globalsolution.repository;

import com.example.globalsolution.entity.AlocacaoMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlocacaoMedicoRepository extends JpaRepository<AlocacaoMedico, Long> {

}
