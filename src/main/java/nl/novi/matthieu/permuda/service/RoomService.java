package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.dto.Room.RoomOutputDto;
import nl.novi.matthieu.permuda.mapper.RoomMapper;
import nl.novi.matthieu.permuda.model.Room;
import nl.novi.matthieu.permuda.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository repository;

    public RoomService(RoomRepository repository) {this.repository = repository;}

    public List<RoomOutputDto> getAllRooms() {
        List<Room> rooms = this.repository.findAll();
        return rooms.stream().map(RoomMapper::toOutputDto).toList();
    }

    public  RoomOutputDto getRoomById(String id) {
        // TODO : test this with non-numeric requestparam
        Room room = this.repository.findRoomById(Long.parseLong(id));
        return RoomMapper.toOutputDto(room);
    }
}
