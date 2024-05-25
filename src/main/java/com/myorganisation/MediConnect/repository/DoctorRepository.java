package com.myorganisation.MediConnect.repository;

import com.myorganisation.MediConnect.model.Doctor;
import com.myorganisation.MediConnect.model.enums.City;
import com.myorganisation.MediConnect.model.enums.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(City city, Speciality speciality);
}
