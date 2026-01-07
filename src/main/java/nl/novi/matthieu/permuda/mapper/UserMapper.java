package nl.novi.matthieu.permuda.mapper;

import nl.novi.matthieu.permuda.dto.User.UserInputDto;
import nl.novi.matthieu.permuda.dto.User.UserOutputDto;
import nl.novi.matthieu.permuda.model.User;

public class UserMapper {

    public static User toEntity(UserInputDto userInputDto) {
        User user = new User();
        user.setUsername(userInputDto.username);
        // password and role are added in the user service
        // TODO : move the password encoding inside this mapper
//        user.setPassword(passwordEncoder.encode(userInputDto.password));
        return user;
    }

    public static UserOutputDto toOutputDto(User user) {
        UserOutputDto userOutputDto = new UserOutputDto();
        userOutputDto.username = user.getUsername();
        // remove "ROLE_" from the rolename before returning it to the user
        userOutputDto.rolename = user.getRole().getRolename().substring(5);
        return userOutputDto;
    }
}
