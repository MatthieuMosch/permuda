package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.service.ActionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actions")
public class ActionController {

    private final ActionService service;

    public ActionController(ActionService service) {this.service = service;}
}
