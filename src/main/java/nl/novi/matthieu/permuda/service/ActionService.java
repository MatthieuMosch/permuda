package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.dto.action.ActionInputDto;
import nl.novi.matthieu.permuda.dto.action.ActionOutputDto;
import nl.novi.matthieu.permuda.mapper.ActionMapper;
import nl.novi.matthieu.permuda.model.Action;
import nl.novi.matthieu.permuda.repository.*;
import nl.novi.matthieu.permuda.util.UserUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService {

    private final AchievementRepository achievementRepository;
    private final ActionRepository actionRepository;
    private final ProfileRepository profileRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public ActionService(AchievementRepository achievementRepository,
                         ActionRepository actionRepository,
                         ProfileRepository profileRepository,
                         RoomRepository roomRepository,
                         UserRepository userRepository) {
        this.achievementRepository = achievementRepository;
        this.actionRepository = actionRepository;
        this.profileRepository = profileRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    public ActionOutputDto addAction(ActionInputDto actionInputDto, String username) {
        // TODO : check if destination exists, otherwise throw an exception
        Action action = ActionMapper.toEntity(actionInputDto);
        action.setRoom(this.roomRepository.findRoomById(actionInputDto.room_id));
        action.setRequirement(this.achievementRepository.findAchievementByTitle(actionInputDto.requirement_title));
        action.setReward(this.achievementRepository.findAchievementByTitle(actionInputDto.reward_title));
        action.setDestination(this.roomRepository.findRoomById(actionInputDto.destination_id));
        action.setOwner(UserUtils.createOwnerProfile(this.userRepository,this.profileRepository,username));
        this.actionRepository.save(action);
        return ActionMapper.toOutputDto(action);
    }

    public List<ActionOutputDto> getAllActions() {
        List<Action> actions = this.actionRepository.findAll();
        return actions.stream().map(ActionMapper::toOutputDto).toList();
    }

    public void deleteAction(long id) {
        this.actionRepository.deleteById(id);
    }
}
