package in.thelattice.MediConnect.dto;

import in.thelattice.MediConnect.model.enums.City;
import in.thelattice.MediConnect.model.enums.Speciality;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DoctorRequest {

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    private City city;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^\\d{10,}$", message = "Phone number must be at least 10 digits")
    private String phoneNumber;

    private Speciality speciality;
}
