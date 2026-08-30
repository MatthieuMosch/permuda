package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.dto.user.ProfileInputDto;
import nl.novi.matthieu.permuda.dto.user.ProfileOutputDto;
import nl.novi.matthieu.permuda.exception.GlobalExceptionHandler;
import nl.novi.matthieu.permuda.exception.ResourceNotFoundException;
import nl.novi.matthieu.permuda.mapper.ProfileMapper;
import nl.novi.matthieu.permuda.model.Profile;
import nl.novi.matthieu.permuda.model.User;
import nl.novi.matthieu.permuda.repository.ProfileRepository;
import nl.novi.matthieu.permuda.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final GlobalExceptionHandler globalExceptionHandler;

    public ProfileService(ProfileRepository profileRepository, UserRepository userRepository, GlobalExceptionHandler globalExceptionHandler) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.globalExceptionHandler = globalExceptionHandler;
    }

    public ProfileOutputDto addProfile(ProfileInputDto profileInputDto, String username) {
        Profile profile = ProfileMapper.toEntity(profileInputDto);
        // TODO : user profile create for new users
        // TODO : check if user or profile already exists
        // TODO : outputdto has problems when a part is null, then the property cant be read
        User user = userRepository.findByUsernameIgnoreCase(username).
                orElseThrow(() -> new ResourceNotFoundException("User with " + username + " does not exist"));
        profile.setUser(user);
//        profile.setUsername(username);
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
