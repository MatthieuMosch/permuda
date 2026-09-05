package nl.novi.matthieu.permuda.dto.user;

import java.util.List;

public class ProfileOutputDto {
    public Long userId;
    public String username;

    public String firstname;
    public String lastname;

    public String email;

    public String bio;

    //avatar filename
    public String avatarFile;

    //avatar picture file bytes does not have to be shown in the profileOutputDto
    //this can be retreived via its specific endpoint
//    public byte[] avatar;

    //owned by profile
    public List<Long> room_ids;
    public List<Long> action_ids;
    public List<String> achievement_titles;
    public List<Long> creature_ids;

}
