package kg.megalab.rooms.services.impl;

import kg.megalab.rooms.mappers.RoomMapper;
import kg.megalab.rooms.models.Room;
import kg.megalab.rooms.models.dto.RoomDto;
import kg.megalab.rooms.repositories.RoomRepo;
import kg.megalab.rooms.services.RoomService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {


    private final RoomRepo roomRepo;
    private final RoomMapper roomMapper;

    public RoomServiceImpl(RoomRepo roomRepo, RoomMapper roomMapper) {
        this.roomRepo = roomRepo;
        this.roomMapper = roomMapper;
    }


    @Override
    public List<RoomDto> getRoomDtos() {
        List<Room> rooms = roomRepo.findAll(Sort.by("capacity"));
        return roomMapper.roomsToRoomDtos(rooms);
    }

    @Override
    public List<RoomDto> findAvailableDtosByPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        return List.of();
    }
}
