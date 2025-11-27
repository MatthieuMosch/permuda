package nl.novi.matthieu.permuda.controller;

import jakarta.validation.Valid;
import nl.novi.matthieu.permuda.dto.LoginDto;
import nl.novi.matthieu.permuda.dto.UserInputDto;
import nl.novi.matthieu.permuda.dto.UserOutputDto;
import nl.novi.matthieu.permuda.security.JwtService;
import nl.novi.matthieu.permuda.service.LoginService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final LoginService loginService;

    public LoginController(AuthenticationManager authenticationManager,
                           JwtService jwtService,
                           LoginService loginService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDto loginDto) {
        // TODO : test exceptions
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.username, loginDto.password);
        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String jwt = jwtService.generateToken(userDetails);
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt)
                    .body("Token generated");
        } catch (AuthenticationException exception) {
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.UNAUTHORIZED);
        }
    }
}
