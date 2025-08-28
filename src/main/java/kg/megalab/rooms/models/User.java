package kg.megalab.rooms.models;

import jakarta.persistence.*;
import kg.megalab.rooms.models.enums.UserRole;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class User {

    @Id
    @GeneratedValue
    Long id;
    @Column(length = 100, nullable = false)
    String name;
    @Column(length = 100, nullable = false, unique = true)
    String email;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    UserRole role;



}
