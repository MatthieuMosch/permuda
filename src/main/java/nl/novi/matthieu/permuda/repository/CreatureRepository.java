package nl.novi.matthieu.permuda.repository;

import nl.novi.matthieu.permuda.model.Creature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatureRepository extends JpaRepository<Creature, Long> {
}
