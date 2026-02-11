package nl.novi.matthieu.permuda.dto.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class ProfileInputDto {
    @NotNull
    public Long userId;

    public String firstname;
    public String lastname;

    @Email(message = "enter a valid email address like name@domain")
    public String email;

    public String picture;
    public String bio;
}
