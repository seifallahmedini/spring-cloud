package com.seifallahmedini.roomreservationservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("guestservices")
public interface GuestClient {
    @GetMapping("/api/v1/guests")
    List<Guest> getGuests();
    @GetMapping("/api/v1/guests/{id}")
    Guest getGuest(@PathVariable("id") Long id);
}
