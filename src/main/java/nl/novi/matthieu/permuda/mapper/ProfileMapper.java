package nl.novi.matthieu.permuda.mapper;

import nl.novi.matthieu.permuda.dto.user.ProfileInputDto;
import nl.novi.matthieu.permuda.dto.user.ProfileOutputDto;
import nl.novi.matthieu.permuda.model.*;

public class ProfileMapper {

    public static Profile toEntity(ProfileInputDto profileInputDto) {
        Profile profile = new Profile();
        profile.setFirstname(profileInputDto.firstname);
        profile.setLastname(profileInputDto.lastname);
        profile.setEmail(profileInputDto.email);
        profile.setPicture(profileInputDto.picture);
        profile.setBio(profileInputDto.bio);
        return profile;
    }

    public static ProfileOutputDto toDto(Profile profile) {
        ProfileOutputDto profileOutputDto = new ProfileOutputDto();
        profileOutputDto.userId = profile.getId();
        profileOutputDto.username = profile.getUsername();
        profileOutputDto.firstname = profile.getFirstname();
        profileOutputDto.lastname = profile.getLastname();
        profileOutputDto.email = profile.getEmail();
        profileOutputDto.picture = profile.getPicture();
        profileOutputDto.bio = profile.getBio();
        profileOutputDto.room_ids = profile.getOwnedRooms().stream().map(Room::getId).toList();
        profileOutputDto.action_ids = profile.getOwnedActions().stream().map(Action::getId).toList();
        profileOutputDto.achievement_titles = profile.getOwnedAchievements().stream().map(Achievement::getTitle).toList();
        profileOutputDto.creature_ids = profile.getOwnedCreatures().stream().map(Creature::getId).toList();
        return profileOutputDto;
    }
}
