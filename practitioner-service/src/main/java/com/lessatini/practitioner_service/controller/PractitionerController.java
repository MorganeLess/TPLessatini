package com.lessatini.practitioner_service.controller;

import com.lessatini.practitioner_service.entity.Practitioner;
import com.lessatini.practitioner_service.service.PractitionerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/practitioners")
public class PractitionerController {

    private final PractitionerService practitionerService;

    @Autowired
    public PractitionerController(PractitionerService practitionerService) {
        this.practitionerService = practitionerService;
    }

    @GetMapping
    public List<Practitioner> getAllPractitioners() {
        return practitionerService.getAllPractitioners();
    }

    @GetMapping("/{id}")
    public Optional<Practitioner> getPractitionerById(@PathVariable Long id) {
        return practitionerService.getPractitionerById(id);
    }

    @PostMapping
    public Practitioner createPractitioner(@RequestBody Practitioner practitioner) {
        return practitionerService.createPractitioner(practitioner);
    }

    @PutMapping("/{id}")
    public Practitioner updatePractitioner(@PathVariable Long id, @RequestBody Practitioner practitioner) {
        return practitionerService.updatePractitioner(id, practitioner);
    }

    @DeleteMapping("/{id}")
    public void deletePractitioner(@PathVariable Long id) {
        practitionerService.deletePractitioner(id);
    }
}
