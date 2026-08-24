package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.dto.user.ProfileInputDto;
import nl.novi.matthieu.permuda.dto.user.ProfileOutputDto;
import nl.novi.matthieu.permuda.mapper.ProfileMapper;
import nl.novi.matthieu.permuda.model.Profile;
import nl.novi.matthieu.permuda.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {this.profileRepository = profileRepository;}

    public ProfileOutputDto addProfile(ProfileInputDto profileInputDto) {
        Profile profile = ProfileMapper.toEntity(profileInputDto);
        this.profileRepository.save(profile);
        return ProfileMapper.toDto(profile);
    }

    public ProfileOutputDto getProfileById(long id) {
        Profile profile = this.profileRepository.findProfileById(id);
        return ProfileMapper.toDto(profile);
    }

    public List<ProfileOutputDto> getAllProfiles() {
    // TODO : only GOD can see it all
        List<Profile> profiles = this.profileRepository.findAll();
        return profiles.stream().map(ProfileMapper::toDto).toList();
    }

    public void deleteProfileById(long id) {
        this.profileRepository.deleteProfileById(id);
    }
}
