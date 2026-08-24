package nl.novi.matthieu.permuda.mapper;

import nl.novi.matthieu.permuda.dto.achievement.AchievementInputDto;
import nl.novi.matthieu.permuda.dto.achievement.AchievementOutputDto;
import nl.novi.matthieu.permuda.model.Achievement;

public class AchievementMapper {

    public static Achievement toEntity(AchievementInputDto achievementInputDto) {
        Achievement achievement = new Achievement();
        achievement.setTitle(achievementInputDto.title);
        return achievement;
    }

    public static AchievementOutputDto toOutputDto(Achievement achievement) {
        AchievementOutputDto achievementOutputDto = new AchievementOutputDto();
        achievementOutputDto.title = achievement.getTitle();
        achievementOutputDto.owner_name = achievement.getOwner().getUsername();
        return achievementOutputDto;
    }
}
