package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {this.service = service;}

    // TODO : get available roles
}
