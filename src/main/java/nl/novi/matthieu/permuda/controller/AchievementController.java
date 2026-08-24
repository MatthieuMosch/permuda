package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.dto.achievement.AchievementInputDto;
import nl.novi.matthieu.permuda.dto.achievement.AchievementOutputDto;
import nl.novi.matthieu.permuda.service.AchievementService;
import nl.novi.matthieu.permuda.util.UriUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/achievements")
public class AchievementController {

    private final AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;}

    // add a new achievement
    @PostMapping
    public ResponseEntity<AchievementOutputDto> addAchievement(
            @RequestBody AchievementInputDto achievementInputDto,
            @AuthenticationPrincipal UserDetails userDetails) {
        AchievementOutputDto achievementOutputDto = this.achievementService.addAchievement(
                achievementInputDto,
                userDetails.getUsername());
        URI uri = UriUtils.createUri(achievementOutputDto.title);
        return ResponseEntity.created(uri).body(achievementOutputDto);
    }

    @GetMapping
    public ResponseEntity<List<AchievementOutputDto>> getAllAchievements() {
        return  ResponseEntity.ok(this.achievementService.getAllAchievements());
    }

    @GetMapping("/{title}")
    public ResponseEntity<AchievementOutputDto> getAchievement(@PathVariable String title) {
        return ResponseEntity.ok(this.achievementService.getAchievementById(title));
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<Void> deleteAchievement(@PathVariable String title) {
        this.achievementService.deleteAchievement(title);
        return ResponseEntity.noContent().build();
    }
}
