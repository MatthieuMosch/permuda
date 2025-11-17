package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.dto.UserInputDto;
import nl.novi.matthieu.permuda.dto.UserOutputDto;
import nl.novi.matthieu.permuda.mapper.UserMapper;
import nl.novi.matthieu.permuda.model.User;
import nl.novi.matthieu.permuda.service.UserService;
import org.springframework.web.bind.annotation.*;

// temp fake database
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

//    // temp fake database list
//    ArrayList<User> users = new ArrayList<User>();

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // add a new user
    @PostMapping
    public UserOutputDto addUser(@RequestBody UserInputDto userInputDto) {
//        this.users.add(UserMapper.toEntity(userInputDto));
//        return this.users;
        // TODO : responsoeentity
        return this.userService.addUser(userInputDto);
    }

    // get a list of all users
    @GetMapping
    public List<UserOutputDto> getUsers() {
//        return this.users;
        return this.userService.getAllUsers();
    }
}
