package nl.novi.matthieu.permuda.dto.room;

import jakarta.validation.constraints.NotBlank;

public class RoomInputDto {
    @NotBlank(message = "Description is required")
    public String description;
}
