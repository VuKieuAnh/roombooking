package com.example.room.service.rooms;

import com.example.room.model.Rooms;
import com.example.room.repository.IRoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomsService implements IRoomsService {
    @Autowired
    private IRoomsRepository roomsRepository;

    @Override
    public Iterable<Rooms> findAll() {
        return roomsRepository.findAll();
    }

    @Override
    public Optional<Rooms> findById(Long id) {
        return roomsRepository.findById(id);
    }

    @Override
    public Rooms save(Rooms rooms) {
        return roomsRepository.save(rooms);
    }

    @Override
    public void remove(Long id) {
        roomsRepository.deleteById(id);
    }
}
