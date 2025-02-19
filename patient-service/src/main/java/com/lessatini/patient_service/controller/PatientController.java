package com.lessatini.patient_service.controller;

import com.lessatini.patient_service.entity.Patient;
import com.lessatini.patient_service.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
@Tag(name = "Patient Management", description = "Operations pertaining to patients in Medical Office")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Get all patients", description = "Retrieves a list of all patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a patient by ID", description = "Retrieves a patient by their ID")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new patient", description = "Creates a new patient entry")
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(patientService.createPatient(patient));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a patient", description = "Updates an existing patient's information")
    public ResponseEntity<Optional<Patient>> updatePatient(@PathVariable Long id, @Valid @RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.updatePatient(id, patient));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a patient", description = "Deletes a patient from the system")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
