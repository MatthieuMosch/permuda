package nl.novi.matthieu.permuda.dto.room;

import java.util.List;

public class RoomOutputDto extends RoomInputDto {
    public long id;
    public List<String> profilesInRoom;
    public List<Long> creaturesInRoom;
    public List<Long> actionsInRoom;
    public List<Long> actionsToRoom;
    public String owner_name;
}