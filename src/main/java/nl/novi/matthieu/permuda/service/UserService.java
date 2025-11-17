package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.dto.UserInputDto;
import nl.novi.matthieu.permuda.dto.UserOutputDto;
import nl.novi.matthieu.permuda.mapper.UserMapper;
import nl.novi.matthieu.permuda.model.User;
import nl.novi.matthieu.permuda.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    // constructor injection of repository
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public UserOutputDto addUser(UserInputDto userInputDto) {
        // TODO : add exceptions
        User user = UserMapper.toEntity(userInputDto);
        this.userRepository.save(user);
        return UserMapper.toDto(user);
    }

    public List<UserOutputDto> getAllUsers() {
        // TODO : add exceptions
        List<User> users = this.userRepository.findAll();
        return users.stream().map(UserMapper::toDto).toList();
    }
}
