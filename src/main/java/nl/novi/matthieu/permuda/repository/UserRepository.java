package nl.novi.matthieu.permuda.repository;

import nl.novi.matthieu.permuda.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    public Optional<User> findByUsernameIgnoreCase(String username);
}


