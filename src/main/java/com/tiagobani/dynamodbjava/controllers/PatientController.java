package com.tiagobani.dynamodbjava.controllers;

import com.tiagobani.dynamodbjava.dtos.request.PostPatientRequest;
import com.tiagobani.dynamodbjava.dtos.request.QueryPatientRequest;
import com.tiagobani.dynamodbjava.dtos.response.PatientResponse;
import com.tiagobani.dynamodbjava.services.IPatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public record PatientController(
        IPatientService patientService
) {

    @GetMapping("/patient")
    public List<PatientResponse> getPatient(
           @Valid QueryPatientRequest params
    ) {
        return patientService.findByParams(params);
    }

    @GetMapping("/patient/{id}")
    public Optional<PatientResponse> getPatientById(@PathVariable String id) {
        return patientService.findById(id);
    }

    @PostMapping("/patient")
    public ResponseEntity<PatientResponse> createPatient(@RequestBody PostPatientRequest patient) {
        return ResponseEntity.ok(patientService.create(patient));
    }
}
