package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.dto.action.ActionInputDto;
import nl.novi.matthieu.permuda.dto.action.ActionOutputDto;
import nl.novi.matthieu.permuda.dto.room.RoomInputDto;
import nl.novi.matthieu.permuda.dto.room.RoomOutputDto;
import nl.novi.matthieu.permuda.service.ActionService;
import nl.novi.matthieu.permuda.service.RoomService;
import nl.novi.matthieu.permuda.util.UriUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;
    private final ActionService actionService;

    public RoomController(RoomService roomService, ActionService actionService) {
        this.roomService = roomService;
        this.actionService = actionService;
    }

    @PostMapping
    public ResponseEntity<RoomOutputDto> addRoom(
            @RequestBody RoomInputDto roomInputDto,
            @AuthenticationPrincipal UserDetails userDetails) {
        RoomOutputDto roomOutputDto = this.roomService.addRoom(roomInputDto, userDetails.getUsername());
        URI uri = UriUtils.createUri(String.valueOf(roomOutputDto.id));
        return ResponseEntity.created(uri).body(roomOutputDto);
    }

    @GetMapping
    public ResponseEntity<List<RoomOutputDto>> getAllRooms() {
        return ResponseEntity.ok(this.roomService.getAllRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomOutputDto> getRoomById(@PathVariable String id) {
        return ResponseEntity.ok(this.roomService.getRoomById(id));
    }

    // add a new action to a room
    // TODO : throw exception when action already exists
    @PatchMapping("/{id}/addAction")
    public ResponseEntity<RoomOutputDto> addActionToRoom(
            @PathVariable long id,
            @RequestBody ActionInputDto actionInputDto,
            @AuthenticationPrincipal UserDetails userDetails) {
        RoomOutputDto roomOutputDto = this.roomService.addAction(id, actionInputDto, userDetails.getUsername());
        return ResponseEntity.ok(roomOutputDto);
    }

    // assign an existing action to a room
    // TODO : throw exception when actionid does not exist
    @PatchMapping("/{id}/assignAction")
    public ResponseEntity<RoomOutputDto> assignAction(
            @PathVariable long id,
            @RequestParam long actionId,
            @AuthenticationPrincipal UserDetails userDetails) {
        ActionInputDto actionInputDto = actionService.getActionById(actionId);
        RoomOutputDto roomOutputDto = this.roomService.addAction(id, actionInputDto, userDetails.getUsername());
        return ResponseEntity.ok(roomOutputDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable long id) {
        this.roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
