package nl.novi.matthieu.permuda.mapper;

import nl.novi.matthieu.permuda.dto.User.UserInputDto;
import nl.novi.matthieu.permuda.dto.User.UserOutputDto;
import nl.novi.matthieu.permuda.model.User;

public class UserMapper {

//    private static PasswordEncoder passwordEncoder;

//    public UserMapper(PasswordEncoder injectedEncoder) {
//        passwordEncoder = injectedEncoder;
//    }

    public static User toEntity(UserInputDto userInputDto) {
        User user = new User();
        user.setUsername(userInputDto.username);
        // TODO : move the password encoding inside this mapper
//        user.setPassword(passwordEncoder.encode(userInputDto.password));
        // password is added in the user service
//        user.setPassword(userInputDto.password);
        // role is added in the user service
//        user.setRole(userInputDto.role);
        return user;
    }

    public static UserOutputDto toOutputDto(User user) {
        UserOutputDto userOutputDto = new UserOutputDto();
        userOutputDto.username = user.getUsername();
        // remove "ROLE_" from the rolemame before returning it to the user
        userOutputDto.rolename = user.getRole().getRolename().substring(5);
        return userOutputDto;
    }
}
