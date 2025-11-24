package nl.novi.matthieu.permuda.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserInputDto {
    // public properties as this is the input DTO which is public anyway
    // no Id property in the input DTO
    @NotBlank
    @Size(min = 3, max = 50)
    public String username;
    @NotBlank
    @Size(min = 8, max = 50)
    public String password;
    @NotBlank
    @Email
    public String email;
}
