package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.dto.room.RoomInputDto;
import nl.novi.matthieu.permuda.dto.room.RoomOutputDto;
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

    public RoomController(RoomService service) {this.roomService = service;}

    @PostMapping
    public ResponseEntity<RoomOutputDto> addRoom(
            @RequestBody RoomInputDto roomInputDto,
            @AuthenticationPrincipal UserDetails userDetails) {
        RoomOutputDto roomOutputDto = this.roomService.addRoom(roomInputDto, userDetails.getUsername());
        URI uri = UriUtils.createUri(String.valueOf(roomOutputDto.id));
        return ResponseEntity.created(uri).body(roomOutputDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable long id) {
        this.roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<RoomOutputDto>> getAllRooms() {
        return ResponseEntity.ok(this.roomService.getAllRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomOutputDto> getRoomById(@PathVariable String id) {
        return ResponseEntity.ok(this.roomService.getRoomById(id));
    }
}
