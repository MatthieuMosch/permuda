package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.dto.UserInputDto;
import nl.novi.matthieu.permuda.mapper.UserMapper;
import nl.novi.matthieu.permuda.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    // temp fake database list
    ArrayList<User> users = new ArrayList<User>();

    // add a new user
    @PostMapping
    public ArrayList<User> addUser(@RequestBody UserInputDto userInputDto) {
        this.users.add(UserMapper.toEntity(userInputDto));
        return this.users;
    }

    // get a list of all users
    @GetMapping
    public ArrayList<User> getUsers() {
        return this.users;
    }
}
