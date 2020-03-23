package com.seifallahmedini.guestservices.repository;

import com.seifallahmedini.guestservices.model.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
}
