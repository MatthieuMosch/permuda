package nl.novi.matthieu.permuda.repository;

import nl.novi.matthieu.permuda.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, String> {
}
