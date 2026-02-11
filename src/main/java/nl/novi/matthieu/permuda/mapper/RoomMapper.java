package nl.novi.matthieu.permuda.mapper;

import nl.novi.matthieu.permuda.dto.Room.RoomInputDto;
import nl.novi.matthieu.permuda.dto.Room.RoomOutputDto;
import nl.novi.matthieu.permuda.model.Room;

public class RoomMapper {

    public static Room toEntity(RoomInputDto roomInputDto) {
        Room room = new Room();
        room.setDescription(roomInputDto.description);
        return room;
    }

    public static RoomOutputDto toOutputDto(Room room) {
        RoomOutputDto roomOutputDto = new RoomOutputDto();
        roomOutputDto.id = room.getId();
        roomOutputDto.description = room.getDescription();
        roomOutputDto.owner = room.getOwner().getUser().getUsername();
        return roomOutputDto;
    }
}
