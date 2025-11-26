package nl.novi.matthieu.permuda.controller;

import jakarta.validation.Valid;
import nl.novi.matthieu.permuda.dto.UserInputDto;
import nl.novi.matthieu.permuda.dto.UserOutputDto;
import nl.novi.matthieu.permuda.service.UserService;
import nl.novi.matthieu.permuda.util.UriUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // constructor injection : service
    public UserController(UserService userService) {this.userService = userService;}

    // add a new user
    @PostMapping
    public ResponseEntity<UserOutputDto> addUser(@Valid @RequestBody UserInputDto userInputDto) {
        UserOutputDto userOutputDto = this.userService.addUser(userInputDto);
        URI uri = UriUtils.createUri(userOutputDto.username);
        return ResponseEntity.created(uri).body(userOutputDto);
    }

    // get a list of all users
    @GetMapping
    public ResponseEntity<List<UserOutputDto>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    // get 1 user
    @GetMapping("/{username}")
    public ResponseEntity<UserOutputDto> getUserById(@PathVariable String username) {
        return ResponseEntity.ok(this.userService.getUserById(username));
    }

    // delete 1 user
    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String username) {
        this.userService.deleteUserById(username);
        return ResponseEntity.noContent().build();
    }
}
