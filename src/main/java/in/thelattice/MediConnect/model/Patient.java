package in.thelattice.MediConnect.model;

import in.thelattice.MediConnect.model.enums.Symptom;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "patient")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String email;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Symptom symptom;

}
