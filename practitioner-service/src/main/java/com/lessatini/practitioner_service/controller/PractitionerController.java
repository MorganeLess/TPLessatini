package com.lessatini.practitioner_service.controller;

import com.lessatini.practitioner_service.entity.Practitioner;
import com.lessatini.practitioner_service.service.PractitionerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/practitioners")
@Tag(name = "Practitioner Management", description = "Operations pertaining to practitioners in Medical Office")
public class PractitionerController {

    private final PractitionerService practitionerService;

    public PractitionerController(PractitionerService practitionerService) {
        this.practitionerService = practitionerService;
    }

    @GetMapping
    @Operation(summary = "Get all practitioners", description = "Retrieves a list of all practitioners")
    public ResponseEntity<List<Practitioner>> getAllPractitioners() {
        return ResponseEntity.ok(practitionerService.getAllPractitioners());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a practitioner by ID", description = "Retrieves a practitioner by their ID")
    public ResponseEntity<Practitioner> getPractitionerById(@PathVariable Long id) {
        return practitionerService.getPractitionerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new practitioner", description = "Creates a new practitioner entry")
    public ResponseEntity<Practitioner> createPractitioner(@Valid @RequestBody Practitioner practitioner) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(practitionerService.createPractitioner(practitioner));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a practitioner", description = "Updates an existing practitioner's information")
    public ResponseEntity<Practitioner> updatePractitioner(@PathVariable Long id, @Valid @RequestBody Practitioner practitioner) {
        return ResponseEntity.ok(practitionerService.updatePractitioner(id, practitioner));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a practitioner", description = "Deletes a practitioner from the system")
    public ResponseEntity<Void> deletePractitioner(@PathVariable Long id) {
        practitionerService.deletePractitioner(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/speciality/{speciality}")
    @Operation(summary = "Get practitioners by speciality", description = "Retrieves all practitioners of a specific speciality")
    public ResponseEntity<List<Practitioner>> getPractitionersBySpeciality(@PathVariable String speciality) {
        return ResponseEntity.ok(practitionerService.getPractitionersBySpeciality(speciality));
    }
}