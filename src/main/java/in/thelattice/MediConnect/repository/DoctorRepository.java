package in.thelattice.MediConnect.repository;

import in.thelattice.MediConnect.model.Doctor;
import in.thelattice.MediConnect.model.enums.City;
import in.thelattice.MediConnect.model.enums.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(City city, Speciality speciality);
}
