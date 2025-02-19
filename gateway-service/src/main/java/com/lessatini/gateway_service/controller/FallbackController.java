package com.lessatini.gateway_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/patient")
    public Map<String, String> patientServiceFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", "Patient service is currently unavailable. Please try again later.");
        return response;
    }

    @GetMapping("/practitioner")
    public Map<String, String> practitionerServiceFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", "Practitioner service is currently unavailable. Please try again later.");
        return response;
    }
}
