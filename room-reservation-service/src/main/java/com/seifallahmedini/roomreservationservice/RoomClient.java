package com.seifallahmedini.roomreservationservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("roomservices")
public interface RoomClient {
    @GetMapping("/api/v1/rooms")
    List<Room> getAllRooms();
    @GetMapping("/api/v1/rooms/{id}")
    Room getRoom(@PathVariable("id") Long id);
}
