package nl.novi.matthieu.permuda.dto.user;

import jakarta.validation.constraints.Email;

public class ProfileInputDto {

    public String firstname;
    public String lastname;

    @Email(message = "enter a valid email address like name@domain")
    public String email;

    public String bio;
}
