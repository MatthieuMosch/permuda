package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.dto.User.ProfileInputDto;
import nl.novi.matthieu.permuda.dto.User.ProfileOutputDto;
import nl.novi.matthieu.permuda.service.ProfileService;
import nl.novi.matthieu.permuda.util.UriUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService profileService) {service = profileService;}

    @PostMapping
    public ResponseEntity<ProfileOutputDto> addProfile(@RequestBody ProfileInputDto profileInputDto) {
        ProfileOutputDto profileOutputDto = this.service.addProfile(profileInputDto);
        URI uri = UriUtils.createUri(profileOutputDto.username);
        return ResponseEntity.created(uri).body(profileOutputDto);
    }

    @GetMapping
    public ResponseEntity<List<ProfileOutputDto>> getAllProfiles() {
        return  ResponseEntity.ok(this.service.getAllProfiles());
    }
}
