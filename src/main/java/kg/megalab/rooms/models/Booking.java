package kg.megalab.rooms.models;

import jakarta.persistence.*;
import kg.megalab.rooms.models.enums.BookingStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking {

    @Id
    @GeneratedValue
    Long id;
    LocalDateTime startDate;
    LocalDateTime endDate;
    @Enumerated(EnumType.STRING)
    BookingStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    @ManyToOne
    @JoinColumn (name = "room_id", nullable = false)
    Room room;


}
