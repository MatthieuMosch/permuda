package nl.novi.matthieu.permuda.controller;

import jakarta.validation.Valid;
import nl.novi.matthieu.permuda.dto.User.LoginDto;
import nl.novi.matthieu.permuda.service.LoginService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<String> login(@Valid @RequestBody LoginDto loginDto) {
        // TODO : test exceptions
        // TODO : return UserOutputDto in body of responseEntity
        try {
            String jwt = loginService.login(loginDto);
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt)
                    .body("JWT in header");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
