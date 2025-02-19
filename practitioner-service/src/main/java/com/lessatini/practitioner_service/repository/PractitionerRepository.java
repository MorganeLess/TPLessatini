package com.lessatini.practitioner_service.repository;

import com.lessatini.practitioner_service.entity.Practitioner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PractitionerRepository extends JpaRepository<Practitioner, Long> {
}