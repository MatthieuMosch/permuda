package nl.novi.matthieu.permuda.dto.Room;

import jakarta.validation.constraints.NotBlank;

public class RoomInputDto {

    @NotBlank(message = "X coordinate is required")
    public long x;

    @NotBlank(message = "Y coordinate is required")
    public long y;

    @NotBlank(message = "Z coordinate is required")
    public long z;

    @NotBlank(message = "Description is required")
    public String description;

}
