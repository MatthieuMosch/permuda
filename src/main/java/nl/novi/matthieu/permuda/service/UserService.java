package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.dto.UserInputDto;
import nl.novi.matthieu.permuda.dto.UserOutputDto;
import nl.novi.matthieu.permuda.exception.ResourceNotFoundException;
import nl.novi.matthieu.permuda.mapper.UserMapper;
import nl.novi.matthieu.permuda.model.User;
import nl.novi.matthieu.permuda.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    // constructor injection : repository
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public UserOutputDto addUser(UserInputDto userInputDto) {
        // TODO : add exceptions
        // add exception when email or username are not unique
        User user = UserMapper.toEntity(userInputDto);
        this.userRepository.save(user);
        return UserMapper.toOutputDto(user);
    }

    public List<UserOutputDto> getAllUsers() {
        // TODO : add exceptions
        // throw exception when there is no user (empty array)
        List<User> users = this.userRepository.findAll();
        return users.stream().map(UserMapper::toOutputDto).toList();
    }

    public UserOutputDto getUserById(int id) {
        // happy flow
        User user = this.userRepository.findById(id)
        //unhappy flow
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " does not exist"));
        return UserMapper.toOutputDto(user);
    }

    public void deleteUserById(int id) {
        // TODO : test for exceptions when the id does not exist
        // TODO : test for exceptions when users is an empty array or null
        this.userRepository.deleteById(id);
    }
}
