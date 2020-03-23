package com.seifallahmedini.roomservices.controller;

import com.seifallahmedini.roomservices.model.Room;
import com.seifallahmedini.roomservices.repository.RoomRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomWebServices {
    private final RoomRepository repository;

    public RoomWebServices(RoomRepository repository) {
        super();
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Room> getAllRooms() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable("id") Long id) {
        return this.repository.findById(id).get();
    }
}
