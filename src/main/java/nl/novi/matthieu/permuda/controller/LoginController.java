package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.dto.UserInputDto;
import nl.novi.matthieu.permuda.dto.UserOutputDto;
import nl.novi.matthieu.permuda.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {this.loginService = loginService;}

    @PostMapping
    public ResponseEntity<UserOutputDto> login(UserInputDto userInputDto) {
        // TODO : test exceptions
        UserOutputDto userOutputDto = this.loginService.login(userInputDto);
        return ResponseEntity.ok(userOutputDto);
    }
}
