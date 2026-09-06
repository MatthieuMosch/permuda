package nl.novi.matthieu.permuda.dto.user;

import jakarta.validation.constraints.NotBlank;

public class UserInputDto extends LoginDto {
    @NotBlank(message = "Rolename is required")
    public String rolename;
}
