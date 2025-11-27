package nl.novi.matthieu.permuda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserInputDto extends LoginDto {
    // public properties as this is the input DTO which is public anyway
    // UserInputDto inherits from LoginDto because they share the same fields
    // so that the code can be changed in 1 location

    @NotBlank(message = "Rolename is required")
    public String rolename;
}
