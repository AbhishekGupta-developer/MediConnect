package com.myorganisation.MediConnect.service;

import com.myorganisation.MediConnect.dto.PatientRequest;
import com.myorganisation.MediConnect.model.Patient;

import java.util.List;

public interface PatientService {
    Patient addPatient(PatientRequest patientRequest);
    void removePatient(Long patientId);
    Patient getPatient(Long patientId);
    List<Patient> getAllPatients();
}
