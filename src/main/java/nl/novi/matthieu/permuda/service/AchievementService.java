package nl.novi.matthieu.permuda.service;

import jakarta.transaction.Transactional;
import nl.novi.matthieu.permuda.dto.achievement.AchievementInputDto;
import nl.novi.matthieu.permuda.dto.achievement.AchievementOutputDto;
import nl.novi.matthieu.permuda.mapper.AchievementMapper;
import nl.novi.matthieu.permuda.model.Achievement;
import nl.novi.matthieu.permuda.repository.AchievementRepository;
import nl.novi.matthieu.permuda.repository.ProfileRepository;
import nl.novi.matthieu.permuda.repository.UserRepository;
import nl.novi.matthieu.permuda.util.UserUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AchievementService {

    private final AchievementRepository achievementRepository;
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public AchievementService(AchievementRepository achievementRepository,
                              ProfileRepository profileRepository,
                              UserRepository userRepository) {
        this.achievementRepository = achievementRepository;
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    public AchievementOutputDto addAchievement(AchievementInputDto achievementInputDto, String username) {
        Achievement achievement = AchievementMapper.toEntity(achievementInputDto);
        achievement.setOwner(UserUtils.createOwnerProfile(this.userRepository,this.profileRepository,username));
        this.achievementRepository.save(achievement);
        return AchievementMapper.toOutputDto(achievement);
    }

    public List<AchievementOutputDto> getAllAchievements() {
        List<Achievement> achievements = this.achievementRepository.findAll();
        return achievements.stream().map(AchievementMapper::toOutputDto).toList();
    }

    public  void deleteAchievement(String title) {
        // TODO : check if title exists
        this.achievementRepository.deleteByTitle(title);
    }
}
