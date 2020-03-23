package com.seifallahmedini.reservationservices.controller;

import com.seifallahmedini.reservationservices.model.Reservation;
import com.seifallahmedini.reservationservices.repository.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationWebServices {
    private final ReservationRepository repository;

    public ReservationWebServices(ReservationRepository repository) {
        super();
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Reservation> getAllReservations(@RequestParam(name = "date", required = false) Date date) {
        if(date != null) {
            return this.repository.findAllByDate(date);
        }
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable("id") Long id) {
        return this.repository.findById(id).get();
    }

}
