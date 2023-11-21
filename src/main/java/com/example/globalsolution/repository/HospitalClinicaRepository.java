package com.example.globalsolution.repository;

import com.example.globalsolution.entity.HospitalClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalClinicaRepository extends JpaRepository<HospitalClinica, Long> {
}
