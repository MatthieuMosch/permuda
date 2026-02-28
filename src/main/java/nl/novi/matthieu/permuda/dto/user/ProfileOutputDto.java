package nl.novi.matthieu.permuda.dto.user;

import nl.novi.matthieu.permuda.model.Room;

import java.util.Set;

public class ProfileOutputDto {
    public Long userId;
    public String username;

    public String firstname;
    public String lastname;

    public String email;

    public String picture;
    public String bio;

    // TODO : return a list of all room_id, not the room itself
    public Set<Room> rooms;
}
