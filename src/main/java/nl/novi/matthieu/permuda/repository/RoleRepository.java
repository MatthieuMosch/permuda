package nl.novi.matthieu.permuda.repository;

import nl.novi.matthieu.permuda.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
    // define your own methods here
}
