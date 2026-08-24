package nl.novi.matthieu.permuda.mapper;

import nl.novi.matthieu.permuda.dto.room.RoomInputDto;
import nl.novi.matthieu.permuda.dto.room.RoomOutputDto;
import nl.novi.matthieu.permuda.model.Action;
import nl.novi.matthieu.permuda.model.Creature;
import nl.novi.matthieu.permuda.model.Profile;
import nl.novi.matthieu.permuda.model.Room;

import java.util.List;

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
        roomOutputDto.profilesInRoom = room.getProfiles().stream().map(Profile::getUsername).toList();
        roomOutputDto.creaturesInRoom = room.getCreatures().stream().map(Creature::getId).toList();
        roomOutputDto.actionsInRoom = room.getActions().stream().map(Action::getId).toList();
        roomOutputDto.actionsToRoom = room.getOrigins().stream().map(Action::getId).toList();
        roomOutputDto.owner_name = room.getOwner().getUser().getUsername();
        return roomOutputDto;
    }
}
