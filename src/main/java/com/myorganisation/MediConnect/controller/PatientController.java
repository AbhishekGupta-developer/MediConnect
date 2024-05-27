package com.myorganisation.MediConnect.controller;

import com.myorganisation.MediConnect.service.PatientService;
import com.myorganisation.MediConnect.dto.PatientRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    Logger logger = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    PatientService patientService;

    @Operation(summary = "Add a new patient", description = "Adds a new patient to the platform")
    @PostMapping
    public ResponseEntity<?> addPatient(@Valid @RequestBody PatientRequest patientRequest) {
        return new ResponseEntity<>(patientService.addPatient(patientRequest), HttpStatusCode.valueOf(201));
    }

    @Operation(summary = "Get the patient", description = "Get the patient by their ID")
    @GetMapping("/{patientId}")
    public ResponseEntity<?> getPatient(@PathVariable Long patientId) {
        return new ResponseEntity<>(patientService.getPatient(patientId), HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Get all patients", description = "Get all patients")
    @GetMapping
    public ResponseEntity<?> getAllPatients() {
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Delete a patient", description = "Deletes a patient by ID")
    @DeleteMapping("/{patientId}")
    public ResponseEntity<?> removePatient(@PathVariable Long patientId) {
        patientService.removePatient(patientId);
        return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }
}
