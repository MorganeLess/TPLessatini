package com.lessatini.practitioner_service.repository;

import com.lessatini.practitioner_service.entity.Practitioner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PractitionerRepository extends JpaRepository<Practitioner, Long> {
    Optional<Practitioner> findByRppsNumber(String rppsNumber);
    List<Practitioner> findBySpeciality(String speciality);
    List<Practitioner> findByLastNameContainingIgnoreCase(String lastName);
}