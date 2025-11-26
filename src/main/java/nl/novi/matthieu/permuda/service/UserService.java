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
        User user = UserMapper.toEntity(userInputDto);
        user.setPassword(passwordEncoder.encode(userInputDto.password));
        // validate role input
        Role role = this.roleRepository.findById("ROLE_" + userInputDto.rolename)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Role " + userInputDto.rolename + " does not exist"));
        // assign validated role to user
        user.setRole(role);
        this.userRepository.save(user);
        return UserMapper.toOutputDto(user);
    }

    public List<UserOutputDto> getAllUsers() {
        // TODO : throw exception when there is no user (empty array)
        List<User> users = this.userRepository.findAll();
        return users.stream().map(UserMapper::toOutputDto).toList();
    }

    public UserOutputDto getUserById(String username) {
        // happy flow
        User user = this.userRepository.findById(username)
        //unhappy flow
                .orElseThrow(() -> new ResourceNotFoundException("User with username " + username + " does not exist"));
        return UserMapper.toOutputDto(user);
    }

    public void deleteUserById(String username) {
        // TODO : test for exceptions when the username does not exist
        // TODO : test for exceptions when users is an empty array or null
        this.userRepository.deleteById(username);
    }
}
