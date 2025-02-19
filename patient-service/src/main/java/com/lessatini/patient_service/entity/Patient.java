package com.lessatini.patient_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le prénom est obligatoire")
    private String firstName;

    @NotBlank(message = "Le nom est obligatoire")
    private String lastName;

    @Email(message = "L'email doit être valide")
    @NotBlank(message = "L'email est obligatoire")
    private String email;

    @Past(message = "La date de naissance doit être dans le passé")
    private LocalDate dateOfBirth;

    @Pattern(regexp = "^\\+?[0-9. -]{10,}$", message = "Numéro de téléphone invalide")
    private String phoneNumber;

    @Column(unique = true)
    @NotBlank(message = "Le numéro de sécurité sociale est obligatoire")
    @Pattern(regexp = "^[0-9]{15}$", message = "Le numéro de sécurité sociale doit contenir 15 chiffres")
    private String socialSecurityNumber;
}