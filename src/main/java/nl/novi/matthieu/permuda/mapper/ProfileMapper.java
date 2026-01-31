package nl.novi.matthieu.permuda.mapper;

import nl.novi.matthieu.permuda.dto.User.ProfileInputDto;
import nl.novi.matthieu.permuda.dto.User.ProfileOutputDto;
import nl.novi.matthieu.permuda.model.Profile;
import nl.novi.matthieu.permuda.model.Room;

import java.util.HashSet;
import java.util.Set;

public class ProfileMapper {

    public static Profile toEntity(ProfileInputDto profileInputDto) {
        Profile profile = new Profile();
        profile.setUserId(profileInputDto.userId);
        profile.setFirstname(profileInputDto.firstname);
        profile.setLastname(profileInputDto.lastname);
        profile.setEmail(profileInputDto.email);
        profile.setPicture(profileInputDto.picture);
        profile.setBio(profileInputDto.bio);
        return profile;
    }

    public static ProfileOutputDto toDto(Profile profile) {
        ProfileOutputDto profileOutputDto = new ProfileOutputDto();
        profileOutputDto.userId = profile.getUserId();
        profileOutputDto.username = profile.getUsername();
        profileOutputDto.firstname = profile.getFirstname();
        profileOutputDto.lastname = profile.getLastname();
        profileOutputDto.email = profile.getEmail();
        profileOutputDto.picture = profile.getPicture();
        profileOutputDto.bio = profile.getBio();
        profileOutputDto.rooms = profile.getRooms();
        return profileOutputDto;
    }
}
