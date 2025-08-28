package kg.megalab.rooms.services;

import kg.megalab.rooms.models.dto.RoomDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface RoomService {
    List<RoomDto> getRoomDtos();

    List<RoomDto> findAvailableDtosByPeriod(LocalDateTime startDate, LocalDateTime endDate);
}
