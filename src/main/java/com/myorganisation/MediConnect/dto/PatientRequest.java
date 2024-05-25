package com.myorganisation.MediConnect.dto;

import com.myorganisation.MediConnect.model.enums.Symptom;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatientRequest {

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    @NotBlank(message = "City is mandatory")
    @Size(max = 20, message = "City must be at most 20 characters long")
    private String city;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^\\d{10,}$", message = "Phone number must be at least 10 digits")
    private String phoneNumber;

    private Symptom symptom;
}
