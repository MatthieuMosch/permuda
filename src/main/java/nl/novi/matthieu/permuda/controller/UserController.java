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
        // TODO : return ResponseEntity<>(HttpStatus.NO_CONTENT) when the result is an empty array
        // TODO : return status 204 (NoContent) without a body when there is no user (empty array)
        // error 204 should not return [] but null ?
//        try {
//            List<Parcela> parcelasFiltradas = veiculosUsecase.filtrarParcelasPorStatus(documento, numeroContrato,
//                    status);//        if (parcelasFiltradas.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//    catch (ParcelasNaoEncontradasException e) {
//            throw new NotFoundException(
//                    "Nao e possivel listar as parcelas porque nao foi encontrado o contrato para o numero de contrato e cliente informado",
//                    "Nao e possivel listar as parcelas porque nao foi encontrado o contrato para o numero de contrato e cliente informado",
//                    HttpStatus.NOT_FOUND.toString(), "External - Veiculos API");
//        }
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    // get 1 user
    @GetMapping("/{username}")
    public ResponseEntity<UserOutputDto> getUserById(@PathVariable String username) {
        return ResponseEntity.ok(this.userService.getUserByUsername(username));
    }

//    // delete 1 user
    @DeleteMapping("/{username}")
    // TODO : throw exception when the current user wants to delete anotehr user
    // TODO : GOD can erase anyone from existence
    public ResponseEntity<Void> deleteUserByUsername(@PathVariable String username) {
        this.userService.deleteUserById(username);
        return ResponseEntity.noContent().build();
    }
}
