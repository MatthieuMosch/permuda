package nl.novi.matthieu.permuda.repository;

import nl.novi.matthieu.permuda.model.Profile;
import nl.novi.matthieu.permuda.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, String> {
    Optional<Profile> findByUser(User user);
    Profile findProfileById(long id);
    void deleteProfileById(long id);
}
