package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.dto.UserInputDto;
import nl.novi.matthieu.permuda.dto.UserOutputDto;
import nl.novi.matthieu.permuda.exception.ResourceNotFoundException;
import nl.novi.matthieu.permuda.mapper.UserMapper;
import nl.novi.matthieu.permuda.model.Role;
import nl.novi.matthieu.permuda.model.User;
import nl.novi.matthieu.permuda.repository.RoleRepository;
import nl.novi.matthieu.permuda.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserOutputDto addUser(UserInputDto userInputDto) {
        // TODO : add exception when username is not unique
        // TODO : convert role input to uppercase
        // TODO : endpointUtils met daarin addEndpoint en deleteEndpoint etc
        // input en service doorgeven ... type object ?
        // hierdoor elke vergelijkbare endpoint zelfde code en op 1 plaats wijzigen
        // of de service methods in een helper class stoppen ?
        // TODO : check for existing user, ignore upper and lower case
        User user = UserMapper.toEntity(userInputDto);
        user.setPassword(passwordEncoder.encode(userInputDto.password));
        // validate role input
        Role role = this.roleRepository.findById("ROLE_" + userInputDto.rolename)
                .orElseThrow(() -> new ResourceNotFoundException("Role " + userInputDto.rolename + " does not exist"));
        // assign validated role to user
        user.setRole(role);
        this.userRepository.save(user);
        return UserMapper.toOutputDto(user);
    }

    public List<UserOutputDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users.stream().map(UserMapper::toOutputDto).toList();
    }

    public UserOutputDto getUserById(String username) {
        User user = this.userRepository.findById(username)
                .orElseThrow(() -> new ResourceNotFoundException("User with username " + username + " does not exist"));
        return UserMapper.toOutputDto(user);
    }

    public void deleteUserById(String username) {
        // TODO : test for exceptions when the username does not exist
        // TODO : test for exceptions when users is an empty array or null
        this.userRepository.deleteById(username);
    }
}
