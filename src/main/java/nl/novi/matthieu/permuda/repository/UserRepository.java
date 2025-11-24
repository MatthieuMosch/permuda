package nl.novi.matthieu.permuda.repository;

import nl.novi.matthieu.permuda.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // define your own methods here
}

