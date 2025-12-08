package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.repository.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {this.profileRepository = profileRepository;}
}
