package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.dto.action.ActionInputDto;
import nl.novi.matthieu.permuda.dto.room.RoomInputDto;
import nl.novi.matthieu.permuda.dto.room.RoomOutputDto;
import nl.novi.matthieu.permuda.exception.ResourceNotFoundException;
import nl.novi.matthieu.permuda.mapper.ActionMapper;
import nl.novi.matthieu.permuda.mapper.RoomMapper;
import nl.novi.matthieu.permuda.model.Action;
import nl.novi.matthieu.permuda.model.Room;
import nl.novi.matthieu.permuda.repository.ActionRepository;
import nl.novi.matthieu.permuda.repository.ProfileRepository;
import nl.novi.matthieu.permuda.repository.RoomRepository;
import nl.novi.matthieu.permuda.repository.UserRepository;
import nl.novi.matthieu.permuda.util.UserUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final ActionRepository actionRepository;
    private final RoomRepository roomRepository;
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public RoomService(ActionRepository actionRepository,
                       RoomRepository repository,
                       ProfileRepository profileRepository,
                       UserRepository userRepository) {
        this.actionRepository = actionRepository;
        this.roomRepository = repository;
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    public RoomOutputDto addRoom(RoomInputDto roomInputDto, String username) {
        Room room = RoomMapper.toEntity(roomInputDto);
        room.setOwner(UserUtils.createOwnerProfile(this.userRepository,this.profileRepository,username));
        this.roomRepository.save(room);
        return RoomMapper.toOutputDto(room);
    }

//    public RoomOutputDto addAction(long id, ActionInputDto actionInputDto, String username) {
//        Room room = roomRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Room with id " + id + " does not exist"));
//        Action action = ActionMapper.toEntity(actionInputDto);
//        action.setRoom(room);
//        action.setOwner(UserUtils.createOwnerProfile(this.userRepository,this.profileRepository,username));
//        this.actionRepository.save(action);
//        return RoomMapper.toOutputDto(room);
//    }

    public List<RoomOutputDto> getAllRooms() {
        // TODO : only GOD can get it all
        List<Room> rooms = this.roomRepository.findAll();
        return rooms.stream().map(RoomMapper::toOutputDto).toList();
    }

    public  RoomOutputDto getRoomById(String id) {
        Room room = this.roomRepository.findRoomById(Long.parseLong(id));
        return RoomMapper.toOutputDto(room);
    }

    public void deleteRoom(long id) {
        // TODO : check if id exists
        this.roomRepository.deleteById(id);
    }
}
