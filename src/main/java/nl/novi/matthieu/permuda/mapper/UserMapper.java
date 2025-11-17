package nl.novi.matthieu.permuda.mapper;

import nl.novi.matthieu.permuda.dto.UserInputDto;
import nl.novi.matthieu.permuda.dto.UserOutputDto;
import nl.novi.matthieu.permuda.model.User;

public class UserMapper {

    public static User toEntity(UserInputDto userInputDto) {
        User user = new User();
        user.setUsername(userInputDto.username);
        user.setPassword(userInputDto.password); // this should be encoded
        user.setEmail(userInputDto.email);
        return user;
    }

    public static UserOutputDto toDto(User user) {
        UserOutputDto userOutputDto = new UserOutputDto();
        userOutputDto.Id = user.getId();
        userOutputDto.username = user.getUsername();
        userOutputDto.email = user.getEmail();
        return userOutputDto;
    }
}
