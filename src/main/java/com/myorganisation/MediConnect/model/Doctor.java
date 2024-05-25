package com.myorganisation.MediConnect.model;

import com.myorganisation.MediConnect.model.enums.City;
import com.myorganisation.MediConnect.model.enums.Speciality;
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
