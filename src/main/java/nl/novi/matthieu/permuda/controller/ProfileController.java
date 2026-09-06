package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.dto.user.ProfileInputDto;
import nl.novi.matthieu.permuda.dto.user.ProfileOutputDto;
import nl.novi.matthieu.permuda.service.ProfileService;
import nl.novi.matthieu.permuda.util.UriUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        // a profile can only be added for the current user
        ProfileOutputDto profileOutputDto = this.profileService.addProfile(profileInputDto, userDetails.getUsername());
        URI uri = UriUtils.createUri(profileOutputDto.username);
        return ResponseEntity.created(uri).body(profileOutputDto);
    }

    @PatchMapping("/{id}/avatar")
    public ResponseEntity<ProfileOutputDto> uploadAvatar(
            @PathVariable long id,
            @RequestBody MultipartFile file) {
        ProfileOutputDto profileOutputDto = this.profileService.uploadAvatar(file, id);
        return  ResponseEntity.ok(profileOutputDto);
    }

    @GetMapping("/{id}/avatar")
    public ResponseEntity<?> downloadAvatar(
            @PathVariable long id,
            @RequestParam String name) {
        if (name == null) name = "avatar.gif";
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + name + "\"")
                .body(this.profileService.downloadAvatar(id));
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
}
