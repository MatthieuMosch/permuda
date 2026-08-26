package nl.novi.matthieu.permuda.dto.user;

import nl.novi.matthieu.permuda.model.Achievement;
import nl.novi.matthieu.permuda.model.Room;

import java.util.List;
import java.util.Set;

public class ProfileOutputDto {
    public Long userId;
    public String username;

    public String firstname;
    public String lastname;

    public String email;

    public String picture;
    public String bio;

    //owned by profile
    public List<Long> room_ids;
    public List<Long> action_ids;
    public List<String> achievement_titles;
    public List<Long> creature_ids;
}
