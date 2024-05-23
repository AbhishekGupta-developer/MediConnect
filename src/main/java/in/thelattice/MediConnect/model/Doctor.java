package in.thelattice.MediConnect.model;

import in.thelattice.MediConnect.model.enums.City;
import in.thelattice.MediConnect.model.enums.Speciality;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "doctor")
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private City city;
    private String email;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

}
