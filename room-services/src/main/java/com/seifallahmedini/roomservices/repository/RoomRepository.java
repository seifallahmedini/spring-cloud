package com.seifallahmedini.roomservices.repository;

import com.seifallahmedini.roomservices.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
