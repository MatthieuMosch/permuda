package nl.novi.matthieu.permuda.repository;

import nl.novi.matthieu.permuda.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findRoomById(long id);
}
