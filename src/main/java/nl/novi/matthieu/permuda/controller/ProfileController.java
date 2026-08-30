package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.dto.user.ProfileInputDto;
import nl.novi.matthieu.permuda.dto.user.ProfileOutputDto;
import nl.novi.matthieu.permuda.service.ProfileService;
import nl.novi.matthieu.permuda.util.UriUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {this.profileService = profileService;}

    @PostMapping
    public ResponseEntity<ProfileOutputDto> addProfile(
            @RequestBody ProfileInputDto profileInputDto,
            @AuthenticationPrincipal UserDetails userDetails) {
        // TODO : a profile can only be added for the current user
        ProfileOutputDto profileOutputDto = this.profileService.addProfile(profileInputDto, userDetails.getUsername());
        URI uri = UriUtils.createUri(profileOutputDto.username);
        return ResponseEntity.created(uri).body(profileOutputDto);
    }

    @GetMapping
    public ResponseEntity<List<ProfileOutputDto>> getAllProfiles() {
        return  ResponseEntity.ok(this.profileService.getAllProfiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileOutputDto> getProfileById(@PathVariable long id) {
        ProfileOutputDto profileOutputDto = this.profileService.getProfileById(id);
        return ResponseEntity.ok(profileOutputDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfileById(@PathVariable long id) {
        this.profileService.deleteProfileById(id);
        return ResponseEntity.noContent().build();
    }
}
