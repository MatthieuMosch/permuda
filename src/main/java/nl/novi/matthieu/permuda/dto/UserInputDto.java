package nl.novi.matthieu.permuda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserInputDto {
    // public properties as this is the input DTO which is public anyway

    @NotBlank(message = "Username is required")
    @Size(message = "Username should be at least 3 characters long", min = 3)
    @Size(message = "Username has a maximum length of 50 characters", max = 50)
    public String username;

    @NotBlank(message = "Password is required")
    @Size(message = "Password should be at least 8 characters long", min = 8)
    public String password;

    @NotBlank(message = "Rolename is required")
    public String rolename;
}
