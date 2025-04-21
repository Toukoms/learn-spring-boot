package com.example.training.service;

import com.example.training.data.entity.RoomEntity;
import com.example.training.data.repository.RoomRepository;
import com.example.training.model.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms() {
        List<RoomEntity> roomEntities = this.roomRepository.findAll();
        List<Room> rooms = new ArrayList<>(roomEntities.size());
        roomEntities.forEach(e -> rooms.add(getRoomFromRoomEntity(e)));
        return rooms;
    }

    public Room getRoomById(UUID id) {
        Optional<RoomEntity> roomEntity = this.roomRepository.findById(id);
        return roomEntity.map(this::getRoomFromRoomEntity).orElse(null);
    }

    public Room addRoom(Room room) {
        RoomEntity roomEntity = this.getRoomEntityFromRoom(room);
        return getRoomFromRoomEntity(this.roomRepository.save(roomEntity));
    }

    public Room updateRoom(UUID id, Room room) {
        room.setId(id);
        RoomEntity roomEntity = this.getRoomEntityFromRoom(room);
        return getRoomFromRoomEntity(this.roomRepository.save(roomEntity));
    }

    public void deleteRoom(UUID id) {
        this.roomRepository.deleteById(id);
    }

    private Room getRoomFromRoomEntity(RoomEntity roomEntity) {
        return new Room(roomEntity.getRoomId(), roomEntity.getName(), roomEntity.getNumber(), roomEntity.getBedInfo());
    }

    private RoomEntity getRoomEntityFromRoom(Room room) {
        return new RoomEntity(room.getId(), room.getName(), room.getNumber(), room.getInfo());
    }
}
