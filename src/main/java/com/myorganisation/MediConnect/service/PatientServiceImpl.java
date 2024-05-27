package com.myorganisation.MediConnect.service;

import com.myorganisation.MediConnect.repository.PatientRepository;
import com.myorganisation.MediConnect.dto.PatientRequest;
import com.myorganisation.MediConnect.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient addPatient(PatientRequest patientRequest) {
        Patient patient = new Patient();
        patient.setName(patientRequest.getName());
        patient.setCity(patientRequest.getCity());
        patient.setEmail(patientRequest.getEmail());
        patient.setPhoneNumber(patientRequest.getPhoneNumber());
        patient.setSymptom(patientRequest.getSymptom());

        return patientRepository.save(patient);
    }

    @Override
    public void removePatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if(patient == null) {
            throw new RuntimeException("Patient not found!  Please recheck the Id.");
        }
        patientRepository.deleteById(patientId);
    }

    @Override
    public Patient getPatient(Long patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
