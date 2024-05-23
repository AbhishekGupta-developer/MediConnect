package in.thelattice.MediConnect.service;

import in.thelattice.MediConnect.dto.PatientRequest;
import in.thelattice.MediConnect.model.Patient;

public interface PatientService {
    Patient addPatient(PatientRequest patientRequest);
    void removePatient(Long patientId);
    Patient getPatient(Long patientId);
}
