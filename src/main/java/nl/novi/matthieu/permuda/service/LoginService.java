package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.dto.User.UserInputDto;
import nl.novi.matthieu.permuda.dto.User.UserOutputDto;
import nl.novi.matthieu.permuda.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final PasswordEncoder passwordEncoder;

    public LoginService(PasswordEncoder passwordEncoder) {this.passwordEncoder = passwordEncoder;}

    public UserOutputDto login(UserInputDto userInputDto) {
        // TODO : add login logica
        UserOutputDto userOutputDto = UserMapper.toOutputDto(UserMapper.toEntity(userInputDto));
        return userOutputDto;
    }
}
