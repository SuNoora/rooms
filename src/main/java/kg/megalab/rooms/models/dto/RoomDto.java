package kg.megalab.rooms.models.dto;

public record RoomDto(
        Long roomId,
        String name,
        int capacity,
        String equipment

) {
}
