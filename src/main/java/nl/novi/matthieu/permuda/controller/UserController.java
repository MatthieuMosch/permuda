package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.dto.UserInputDto;
import nl.novi.matthieu.permuda.dto.UserOutputDto;
import nl.novi.matthieu.permuda.service.UserService;
import nl.novi.matthieu.permuda.util.UriUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // constructor injection of service
    public UserController(UserService userService) {this.userService = userService;}

    // add a new user
    @PostMapping
    public ResponseEntity<UserOutputDto> addUser(@RequestBody UserInputDto userInputDto) {
        UserOutputDto userOutputDto = this.userService.addUser(userInputDto);
        URI uri = UriUtils.createUri(userOutputDto.id);
        return ResponseEntity.created(uri).body(userOutputDto);
    }

    // get a list of all users
    @GetMapping
    public ResponseEntity<List<UserOutputDto>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
}
