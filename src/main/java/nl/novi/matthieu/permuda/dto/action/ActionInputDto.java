package nl.novi.matthieu.permuda.dto.action;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ActionInputDto {
    @NotNull
    public long room_id;
    @NotBlank
    public String command;
    public String requirement_title;
    public String succes;
    public String fail;
    public String reward_title;
    public Long destination_id;
}
