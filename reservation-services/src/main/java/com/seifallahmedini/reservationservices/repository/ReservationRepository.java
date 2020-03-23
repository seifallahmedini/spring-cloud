package com.seifallahmedini.reservationservices.repository;

import com.seifallahmedini.reservationservices.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> findAllByDate(Date date);
}
