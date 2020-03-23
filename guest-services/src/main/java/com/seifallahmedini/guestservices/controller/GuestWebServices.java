package com.seifallahmedini.guestservices.controller;

import com.seifallahmedini.guestservices.model.Guest;
import com.seifallahmedini.guestservices.repository.GuestRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/guests")
public class GuestWebServices {
    private final GuestRepository repository;

    public GuestWebServices(GuestRepository repository) {
        super();
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Guest> getAllGuests() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable("id") Long id) {
        return this.repository.findById(id).get();
    }
}
