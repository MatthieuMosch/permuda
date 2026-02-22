package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.dto.room.RoomInputDto;
import nl.novi.matthieu.permuda.dto.room.RoomOutputDto;
import nl.novi.matthieu.permuda.mapper.RoomMapper;
import nl.novi.matthieu.permuda.model.Room;
import nl.novi.matthieu.permuda.repository.ProfileRepository;
import nl.novi.matthieu.permuda.repository.RoomRepository;
import nl.novi.matthieu.permuda.repository.UserRepository;
import nl.novi.matthieu.permuda.util.UserUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public RoomService(RoomRepository repository,
                       ProfileRepository profileRepository,
                       UserRepository userRepository) {
        this.roomRepository = repository;
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    public RoomOutputDto addRoom(RoomInputDto roomInputDto, String username) {
        Room room = RoomMapper.toEntity(roomInputDto);
        room.setDescription(roomInputDto.description);
        room.setOwner(UserUtils.createOwnerProfile(this.userRepository,this.profileRepository,username));
        this.roomRepository.save(room);
        return RoomMapper.toOutputDto(room);
    }

    public List<RoomOutputDto> getAllRooms() {
        List<Room> rooms = this.roomRepository.findAll();
        return rooms.stream().map(RoomMapper::toOutputDto).toList();
    }

    public  RoomOutputDto getRoomById(String id) {
        // TODO : test this with non-numeric requestparam
        Room room = this.roomRepository.findRoomById(Long.parseLong(id));
        return RoomMapper.toOutputDto(room);
    }
}
