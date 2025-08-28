package kg.megalab.rooms.mappers;

import kg.megalab.rooms.models.Room;
import kg.megalab.rooms.models.dto.RoomDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomMapper INSTANSE = Mappers.getMapper(RoomMapper.class);

    @Mapping(source = "id", target = "roomId")
    RoomDto roomToRoomDto(Room room);

    List<RoomDto> roomsToRoomDtos(List<Room> rooms);
}
