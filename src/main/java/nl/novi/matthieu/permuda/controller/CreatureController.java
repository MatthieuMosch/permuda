package nl.novi.matthieu.permuda.controller;

import nl.novi.matthieu.permuda.dto.creature.CreatureInputDto;
import nl.novi.matthieu.permuda.dto.creature.CreatureOutputDto;
import nl.novi.matthieu.permuda.service.CreatureService;
import nl.novi.matthieu.permuda.util.UriUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/creatures")
public class CreatureController {

    private final CreatureService creatureService;

    public CreatureController(CreatureService creatureService) {this.creatureService = creatureService;}

    @PostMapping
    public ResponseEntity<CreatureOutputDto> addCreature(
            @RequestBody CreatureInputDto creatureInputDto,
            @AuthenticationPrincipal UserDetails userDetails) {
        CreatureOutputDto creatureOutputDto = this.creatureService.addCreature(creatureInputDto, userDetails.getUsername());
        URI uri = UriUtils.createUri(String.valueOf(creatureOutputDto.id));
        return ResponseEntity.created(uri).body(creatureOutputDto);
    }

    @GetMapping
    public ResponseEntity<List<CreatureOutputDto>> getAllCreatures() {
        return  ResponseEntity.ok(this.creatureService.getAllCreatures());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreature(@PathVariable long id) {
        this.creatureService.deleteCreature(id);
        return ResponseEntity.noContent().build();
    }
}
