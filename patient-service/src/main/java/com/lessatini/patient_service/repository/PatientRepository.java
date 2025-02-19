package com.lessatini.patient_service.repository;

import com.lessatini.patient_service.entity.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findBySocialSecurityNumber(String socialSecurityNumber);
    List<Patient> findByLastNameContainingIgnoreCase(String lastName);
}