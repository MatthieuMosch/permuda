package nl.novi.matthieu.permuda.dto.achievement;

import jakarta.validation.constraints.NotBlank;

public class AchievementInputDto {
    @NotBlank
    public String title;
}
