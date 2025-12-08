package nl.novi.matthieu.permuda.mapper;

import nl.novi.matthieu.permuda.dto.Room.RoomInputDto;
import nl.novi.matthieu.permuda.dto.Room.RoomOutputDto;
import nl.novi.matthieu.permuda.model.Room;

public class RoomMapper {

    public static Room toEntity(RoomInputDto roomInputDto) {
        Room room = new Room();
        room.setX(roomInputDto.x);
        room.setY(roomInputDto.y);
        room.setZ(roomInputDto.z);
        room.setDescription(roomInputDto.description);
        return room;
    }

    public static RoomOutputDto toOutputDto(Room room) {
        RoomOutputDto roomOutputDto = new RoomOutputDto();
        roomOutputDto.id = room.getId();
        roomOutputDto.x = room.getX();
        roomOutputDto.y = room.getY();
        roomOutputDto.z = room.getZ();
        roomOutputDto.description = room.getDescription();
        roomOutputDto.owner = room.getProfile().getUser().getUsername();
        return roomOutputDto;
    }
}
