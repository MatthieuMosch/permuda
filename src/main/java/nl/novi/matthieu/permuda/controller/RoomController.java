package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.dto.Room.RoomOutputDto;
import nl.novi.matthieu.permuda.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService service;

    public RoomController(RoomService service) {this.service = service;}

    @GetMapping
    public ResponseEntity<List<RoomOutputDto>> getAllRooms() {
        return ResponseEntity.ok(this.service.getAllRooms());
    }
}
