package nl.novi.matthieu.permuda.mapper;

import nl.novi.matthieu.permuda.dto.user.ProfileInputDto;
import nl.novi.matthieu.permuda.dto.user.ProfileOutputDto;
import nl.novi.matthieu.permuda.model.Profile;

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
        // TODO : return a list of room_id, not the rooms itself
        profileOutputDto.rooms = profile.getOwnedRooms();
        return profileOutputDto;
    }
}
