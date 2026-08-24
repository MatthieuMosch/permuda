package nl.novi.matthieu.permuda.mapper;

import nl.novi.matthieu.permuda.dto.creature.CreatureInputDto;
import nl.novi.matthieu.permuda.dto.creature.CreatureOutputDto;
import nl.novi.matthieu.permuda.model.Creature;

public class CreatureMapper {
    public static Creature toEntity(CreatureInputDto creatureInputDto) {
        Creature creature = new Creature();
        creature.setDescription(creatureInputDto.description);
        return creature;
    }

    public static CreatureOutputDto toOutputDto(Creature creature) {
        CreatureOutputDto creatureOutputDto = new CreatureOutputDto();
        creatureOutputDto.id = creature.getId();
        creatureOutputDto.description = creature.getDescription();
        creatureOutputDto.room_id = creature.getRoom().getId();
        creatureOutputDto.owner_name = creature.getOwner().getUsername();
        return creatureOutputDto;
    }
}
