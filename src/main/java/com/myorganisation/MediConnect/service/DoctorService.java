package com.myorganisation.MediConnect.service;

import com.myorganisation.MediConnect.dto.DoctorRequest;
import com.myorganisation.MediConnect.model.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor addDoctor(DoctorRequest doctorRequest);
    void removeDoctor(Long doctorId);
    Doctor getDoctor(Long doctorId);
    List<Doctor> getAllDoctors();
    List<Doctor> suggestDoctors(Long patientId);
}
