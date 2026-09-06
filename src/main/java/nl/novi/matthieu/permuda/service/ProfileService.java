package nl.novi.matthieu.permuda.service;

import jakarta.transaction.Transactional;
import nl.novi.matthieu.permuda.dto.user.ProfileInputDto;
import nl.novi.matthieu.permuda.dto.user.ProfileOutputDto;
import nl.novi.matthieu.permuda.exception.FileStorageException;
import nl.novi.matthieu.permuda.exception.GlobalExceptionHandler;
import nl.novi.matthieu.permuda.exception.ResourceNotFoundException;
import nl.novi.matthieu.permuda.mapper.ProfileMapper;
import nl.novi.matthieu.permuda.model.Profile;
import nl.novi.matthieu.permuda.model.User;
import nl.novi.matthieu.permuda.repository.ProfileRepository;
import nl.novi.matthieu.permuda.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final GlobalExceptionHandler globalExceptionHandler;

    public ProfileService(ProfileRepository profileRepository,
                          UserRepository userRepository,
                          GlobalExceptionHandler globalExceptionHandler) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.globalExceptionHandler = globalExceptionHandler;
    }

    public ProfileOutputDto addProfile(ProfileInputDto profileInputDto, String username) {
        Profile profile = ProfileMapper.toEntity(profileInputDto);
        User user = userRepository.findByUsernameIgnoreCase(username).
                orElseThrow(() -> new ResourceNotFoundException("User with " + username + " does not exist"));
        profile.setUser(user);
        this.profileRepository.save(profile);
        return ProfileMapper.toDto(profile);
    }

    public ProfileOutputDto uploadAvatar(MultipartFile avatarFile, Long id) {
        Profile profile= this.profileRepository.findProfileById(id);
        try {
            profile.setAvatarFile(avatarFile.getOriginalFilename());
            profile.setAvatar(avatarFile.getBytes());
            this.profileRepository.save(profile);
            return ProfileMapper.toDto(profile);
        } catch (Exception e) {
            throw new FileStorageException(
                    "Could not add avatar with file " + avatarFile.getOriginalFilename(), e);
        }
    }

    @Transactional
    public byte[] downloadAvatar(long id) {
        Profile profile = this.profileRepository.findProfileById(id);
        return profile.getAvatar();
    }

    public ProfileOutputDto getProfileById(long id) {
        Profile profile = this.profileRepository.findProfileById(id);
        return ProfileMapper.toDto(profile);
    }

    public List<ProfileOutputDto> getAllProfiles() {
        List<Profile> profiles = this.profileRepository.findAll();
        return profiles.stream().map(ProfileMapper::toDto).toList();
    }

}
