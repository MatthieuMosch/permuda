package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.dto.User.ProfileInputDto;
import nl.novi.matthieu.permuda.dto.User.ProfileOutputDto;
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

    public List<ProfileOutputDto> getAllProfiles() {
        List<Profile> profiles = this.profileRepository.findAll();
        return profiles.stream().map(ProfileMapper::toDto).toList();
    }
}
