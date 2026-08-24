package nl.novi.matthieu.permuda.dto.creature;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreatureInputDto {
    @NotBlank
    public String description;
    @NotNull
    public long room_id;
}
