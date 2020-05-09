package com.example.room.repository;


import com.example.room.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomsRepository extends JpaRepository<Rooms, Long> {
}
