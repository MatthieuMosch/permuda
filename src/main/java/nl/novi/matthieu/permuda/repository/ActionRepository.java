package nl.novi.matthieu.permuda.repository;

import nl.novi.matthieu.permuda.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Long> {
}
