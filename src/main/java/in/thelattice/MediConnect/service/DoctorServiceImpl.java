package in.thelattice.MediConnect.service;

import in.thelattice.MediConnect.dto.DoctorRequest;
import in.thelattice.MediConnect.exception.CityOrDoctorNotPresentException;
import in.thelattice.MediConnect.model.Doctor;
import in.thelattice.MediConnect.model.Patient;
import in.thelattice.MediConnect.model.enums.City;
import in.thelattice.MediConnect.model.enums.Speciality;
import in.thelattice.MediConnect.model.enums.Symptom;
import in.thelattice.MediConnect.repository.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    Logger logger = LoggerFactory.getLogger(DoctorServiceImpl.class);

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientService patientService;

    @Override
    public Doctor addDoctor(DoctorRequest doctorRequest) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorRequest.getName());
        doctor.setCity(doctorRequest.getCity());
        doctor.setEmail(doctorRequest.getEmail());
        doctor.setPhoneNumber(doctorRequest.getPhoneNumber());
        doctor.setSpeciality(doctorRequest.getSpeciality());

        return doctorRepository.save(doctor);
    }

    @Override
    public void removeDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        if(doctor == null) {
            throw new RuntimeException("Doctor not found! Please recheck the Id.");
        }
        doctorRepository.deleteById(doctorId);
    }

    @Override
    public List<Doctor> suggestDoctors(Long patientId) {

        Patient patient = patientService.getPatient(patientId);

        if(patient == null) {
            throw new RuntimeException("Patient not found!  Please recheck the Id.");
        }

        City patientCity;
        try {
            patientCity = City.valueOf(patient.getCity().toUpperCase());
        } catch (Exception ex) {
            throw new CityOrDoctorNotPresentException("We are still waiting to expand to your location.");
        }

        Speciality neededSpecialistForPatient = getSpeciality(patient.getSymptom());

        List<Doctor> doctors = doctorRepository.findByCityAndSpeciality(patientCity, neededSpecialistForPatient);
        if(doctors.isEmpty()) {
            throw new CityOrDoctorNotPresentException("There isn’t any doctor present at your location for your symptom.");
        }

        return doctors;
    }

    Speciality getSpeciality(Symptom symptom) {
        return switch (symptom) {
            case ARTHRITIS, BACK_PAIN, TISSUE_INJURIES -> Speciality.ORTHOPEDIC;
            case DYSMENORRHEA -> Speciality.GYNECOLOGY;
            case SKIN_INFECTION, SKIN_BURN -> Speciality.DERMATOLOGY;
            case EAR_PAIN -> Speciality.ENT;
            default -> null;
        };
    }

}
