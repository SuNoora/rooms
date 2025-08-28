package kg.megalab.rooms.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "rooms")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room {


    @Id
    @GeneratedValue
    Long id;
    @Column(nullable = false, unique = true)
    String name;
    int capacity;
    String equipment;
}
