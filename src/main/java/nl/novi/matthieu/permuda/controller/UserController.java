package nl.novi.matthieu.permuda.controller;

import jakarta.validation.Valid;
import nl.novi.matthieu.permuda.dto.user.UserInputDto;
import nl.novi.matthieu.permuda.dto.user.UserOutputDto;
import nl.novi.matthieu.permuda.service.UserService;
import nl.novi.matthieu.permuda.util.UriUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

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
        return ResponseEntity.ok(this.userService.getUserByUsername(username));
    }

    // delete 1 user
    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUserByUsername(@PathVariable String username) {
        this.userService.deleteUserById(username);
        return ResponseEntity.noContent().build();
    }
}
