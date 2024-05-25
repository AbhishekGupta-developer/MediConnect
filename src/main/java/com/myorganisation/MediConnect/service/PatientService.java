package com.myorganisation.MediConnect.service;

import com.myorganisation.MediConnect.dto.PatientRequest;
import com.myorganisation.MediConnect.model.Patient;

public interface PatientService {
    Patient addPatient(PatientRequest patientRequest);
    void removePatient(Long patientId);
    Patient getPatient(Long patientId);
}
