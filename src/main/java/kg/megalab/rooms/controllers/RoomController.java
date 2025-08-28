package kg.megalab.rooms.controllers;

import jakarta.annotation.Resource;
import kg.megalab.rooms.models.dto.RoomDto;
//import kg.megalab.rooms.services.RoomService;
import kg.megalab.rooms.services.RoomService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }


    @GetMapping("")
    public ResponseEntity<?> getAllRooms(){
        List<RoomDto> roomDtos = roomService.getRoomDtos();
        if(roomDtos.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(roomDtos);
    }


    @GetMapping("/available")
    public ResponseEntity<?> getAvailableRoomsByPeriod(@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm") LocalDateTime startDate,
                                                       @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm") LocalDateTime endDate){
        List<RoomDto> roomDtos = roomService.findAvailableDtosByPeriod(startDate, endDate);
        if (roomDtos.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(roomDtos);
    }

}
