package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.dto.action.ActionInputDto;
import nl.novi.matthieu.permuda.dto.action.ActionOutputDto;
import nl.novi.matthieu.permuda.service.ActionService;
import nl.novi.matthieu.permuda.util.UriUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/actions")
public class ActionController {

    private final ActionService actionService;

    public ActionController(ActionService actionService) {this.actionService = actionService;}

    @PostMapping
    public ResponseEntity<ActionOutputDto> addAction(
            @RequestBody ActionInputDto actionInputDto,
            @AuthenticationPrincipal UserDetails userDetails) {
        ActionOutputDto actionOutputDto = this.actionService.addAction(actionInputDto, userDetails.getUsername());
        URI uri = UriUtils.createUri(String.valueOf(actionOutputDto.id));
        return ResponseEntity.created(uri).body(actionOutputDto);
    }

    @GetMapping
    public ResponseEntity<List<ActionOutputDto>> getAllActions(){
        return  ResponseEntity.ok(this.actionService.getAllActions());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAction(@PathVariable long id) {
        this.actionService.deleteAction(id);
        return ResponseEntity.noContent().build();
    }
}
