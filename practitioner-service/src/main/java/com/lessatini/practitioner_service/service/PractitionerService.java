package com.lessatini.practitioner_service.service;


import com.lessatini.practitioner_service.entity.Practitioner;
import com.lessatini.practitioner_service.repository.PractitionerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PractitionerService {

    private final PractitionerRepository practitionerRepository;

    public PractitionerService(PractitionerRepository practitionerRepository) {
        this.practitionerRepository = practitionerRepository;
    }

    public List<Practitioner> getAllPractitioners() {
        return practitionerRepository.findAll();
    }

    public Optional<Practitioner> getPractitionerById(Long id) {
        return practitionerRepository.findById(id);
    }

    public Practitioner createPractitioner(Practitioner practitioner) {
        if (practitionerRepository.findByRppsNumber(practitioner.getRppsNumber()).isPresent()) {
            throw new RuntimeException("Practitioner with this RPPS number already exists");
        }
        return practitionerRepository.save(practitioner);
    }

    public Practitioner updatePractitioner(Long id, Practitioner practitioner) {
        if (!practitionerRepository.existsById(id)) {
            throw new RuntimeException("Practitioner not found");
        }
        practitioner.setId(id);
        return practitionerRepository.save(practitioner);
    }

    public void deletePractitioner(Long id) {
        practitionerRepository.deleteById(id);
    }

    public List<Practitioner> getPractitionersBySpeciality(String speciality) {
        return practitionerRepository.findBySpeciality(speciality);
    }
}
