package in.thelattice.MediConnect.service;

import in.thelattice.MediConnect.dto.DoctorRequest;
import in.thelattice.MediConnect.model.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor addDoctor(DoctorRequest doctorRequest);
    void removeDoctor(Long doctorId);
    List<Doctor> suggestDoctors(Long patientId);
}
