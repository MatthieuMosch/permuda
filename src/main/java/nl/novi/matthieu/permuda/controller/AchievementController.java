package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.service.AchievementService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/achievements")
public class AchievementController {

    private final AchievementService service;

    public AchievementController(AchievementService service) {this.service = service;}
}
