package com.lessatini.patient_service.service;

import com.lessatini.patient_service.entity.Patient;
import com.lessatini.patient_service.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient createPatient(Patient patient) {
        if (patientRepository.findBySocialSecurityNumber(patient.getSocialSecurityNumber()).isPresent()) {
            throw new RuntimeException("Patient with this social security number already exists");
        }
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient patient) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found");
        }
        patient.setId(id);
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}