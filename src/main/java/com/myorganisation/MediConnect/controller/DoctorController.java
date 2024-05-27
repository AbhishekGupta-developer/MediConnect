package com.myorganisation.MediConnect.controller;

import com.myorganisation.MediConnect.dto.DoctorRequest;
import com.myorganisation.MediConnect.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Operation(summary = "Add a new doctor", description = "Adds a new doctor to the platform")
    @PostMapping
    public ResponseEntity<?> addDoctor(@Valid @RequestBody DoctorRequest doctorRequest) {
        return new ResponseEntity<>(doctorService.addDoctor(doctorRequest), HttpStatusCode.valueOf(201));
    }

    @Operation(summary = "Get the doctor", description = "Get the doctor by their ID")
    @GetMapping("/{doctorId}")
    public ResponseEntity<?> getDoctor(@PathVariable Long doctorId) {
        return new ResponseEntity<>(doctorService.getDoctor(doctorId), HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Get all doctors", description = "Get all doctors")
    @GetMapping
    public ResponseEntity<?> getAllDoctors() {
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Delete the doctor", description = "Deletes the doctor by ID")
    @DeleteMapping("/{doctorId}")
    public ResponseEntity<?> removeDoctor(@PathVariable Long doctorId) {
        doctorService.removeDoctor(doctorId);
        return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }

    @Operation(summary = "Get the list of suggested doctors", description = "Provides the list of doctors based on your city and symptom")
    @GetMapping("/suggest")
    public ResponseEntity<?> suggestDoctors(@RequestParam(name = "patientId") Long patientId) {
        return new ResponseEntity<>(doctorService.suggestDoctors(patientId), HttpStatusCode.valueOf(200));
    }

}
