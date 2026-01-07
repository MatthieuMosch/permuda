package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.service.CreatureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creatures")
public class CreatureController {

    private final CreatureService service;

    public CreatureController(CreatureService service) {this.service = service;}
}
