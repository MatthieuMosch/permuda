package nl.novi.matthieu.permuda.util;

import nl.novi.matthieu.permuda.exception.ResourceNotFoundException;
import nl.novi.matthieu.permuda.model.Profile;
import nl.novi.matthieu.permuda.model.User;
import nl.novi.matthieu.permuda.repository.ProfileRepository;
import nl.novi.matthieu.permuda.repository.UserRepository;

public class UserUtils {
    public static Profile createOwnerProfile(
            UserRepository userRepository,
            ProfileRepository profileRepository,
            String username) {
        User user = userRepository.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new ResourceNotFoundException("User with username " + username + " does not exist"));;
        Profile owner = profileRepository.findByUser(user)
                .orElseThrow(() -> new ResourceNotFoundException("Profile with username " + username + " does not exist"));
        return owner;
    }
}
