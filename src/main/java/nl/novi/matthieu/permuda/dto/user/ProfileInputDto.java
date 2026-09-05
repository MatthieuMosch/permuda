package nl.novi.matthieu.permuda.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class ProfileInputDto {
    // TODO : retreive username from logged in user and not from the inputdto
//    @NotNull
//    public String username;

    public String firstname;
    public String lastname;

    @Email(message = "enter a valid email address like name@domain")
    public String email;

//    public String picture;
    public String bio;
}
