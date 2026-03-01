package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.dto.creature.CreatureInputDto;
import nl.novi.matthieu.permuda.dto.creature.CreatureOutputDto;
import nl.novi.matthieu.permuda.mapper.CreatureMapper;
import nl.novi.matthieu.permuda.model.Creature;
import nl.novi.matthieu.permuda.repository.CreatureRepository;
import nl.novi.matthieu.permuda.repository.ProfileRepository;
import nl.novi.matthieu.permuda.repository.RoomRepository;
import nl.novi.matthieu.permuda.repository.UserRepository;
import nl.novi.matthieu.permuda.util.UserUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreatureService {

    private final CreatureRepository creatureRepository;
    private final ProfileRepository profileRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public CreatureService(CreatureRepository creatureRepository,
                           ProfileRepository profileRepository,
                           RoomRepository roomRepository,
                           UserRepository userRepository) {
        this.creatureRepository = creatureRepository;
        this.profileRepository = profileRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    public CreatureOutputDto addCreature(CreatureInputDto creatureInputDto, String username) {
        Creature creature = CreatureMapper.toEntity(creatureInputDto);
        creature.setDescription(creatureInputDto.description);
        creature.setRoom(roomRepository.findRoomById(creatureInputDto.room_id));
        creature.setOwner(UserUtils.createOwnerProfile(this.userRepository,this.profileRepository,username));
        this.creatureRepository.save(creature);
        return CreatureMapper.toOutputDto(creature);
    }

    public List<CreatureOutputDto> getAllCreatures(){
        List<Creature> creatures = this.creatureRepository.findAll();
        return creatures.stream().map(CreatureMapper::toOutputDto).toList();
    }

    public CreatureOutputDto getCreatureById(long id){
        Creature creature = this.creatureRepository.findCreatureById(id);
        return CreatureMapper.toOutputDto(creature);
    }

    public void deleteCreature(long id) {
        this.creatureRepository.deleteById(id);
    }
}
