package nl.novi.matthieu.permuda.mapper;

import nl.novi.matthieu.permuda.dto.action.ActionInputDto;
import nl.novi.matthieu.permuda.dto.action.ActionOutputDto;
import nl.novi.matthieu.permuda.model.Achievement;
import nl.novi.matthieu.permuda.model.Action;
import nl.novi.matthieu.permuda.model.Room;

public class ActionMapper {
    public static Action toEntity(ActionInputDto actionInputDto) {
        Action action = new Action();
        action.setCommand(actionInputDto.command);
        action.setSucces(actionInputDto.succes);
        action.setFail(actionInputDto.fail);
        return action;
    }

    public static ActionOutputDto toOutputDto(Action action) {
        ActionOutputDto actionOutputDto = new ActionOutputDto();
        actionOutputDto.id = action.getId();
        actionOutputDto.room_id = action.getRoom().getId();
        actionOutputDto.command = action.getCommand();
        Achievement requirement = action.getRequirement();
        if (requirement != null) actionOutputDto.requirement_title = requirement.getTitle();
        Achievement reward = action.getReward();
        if (reward != null) actionOutputDto.reward_title = reward.getTitle();
        Room destination = action.getDestination();
        if (destination != null) actionOutputDto.destination_id = destination.getId();
        actionOutputDto.succes = action.getSucces();
        actionOutputDto.fail = action.getFail();
        actionOutputDto.owner_name = action.getOwner().getUsername();
        return actionOutputDto;
    }
}
