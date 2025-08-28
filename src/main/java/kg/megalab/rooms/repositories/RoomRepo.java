package kg.megalab.rooms.repositories;

import kg.megalab.rooms.models.Room;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {


    /*
    select * from rooms
where id not in (
select room_id from booking
where status = 'ACTIVE'
and (sd between startDate and endDate
or startDate between sd and ed))
     */

    @Query("select u from Room u where u.id not in " +
            "(select b.room.id from Booking b where b.status = 'ACTIVE' and " +
            "(:startDate between b.startDate and b.endDate or " +
            "b.startDate between :startDate and :endDate))")
    List<Room> findAvailableRooms(LocalDateTime startDate, LocalDateTime endDate);
}
