package nl.novi.matthieu.permuda.mapper;

import nl.novi.matthieu.permuda.dto.room.RoomInputDto;
import nl.novi.matthieu.permuda.dto.room.RoomOutputDto;
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
        roomOutputDto.owner_name = room.getOwner().getUser().getUsername();
        return roomOutputDto;
    }
}
