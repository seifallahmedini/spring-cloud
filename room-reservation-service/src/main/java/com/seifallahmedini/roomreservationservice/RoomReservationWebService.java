package com.seifallahmedini.roomreservationservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@RestController
@RequestMapping("/api/v1/room-reservations")
public class RoomReservationWebService {
    private final RoomClient roomClient;
    private final ReservationClient reservationClient;
    private final GuestClient guestClient;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public RoomReservationWebService(RoomClient roomClient, ReservationClient reservationClient, GuestClient guestClient) {
        super();
        this.roomClient = roomClient;
        this.reservationClient = reservationClient;
        this.guestClient = guestClient;
    }

    @GetMapping
    public List<RoomReservation> getRoomReservations(@RequestParam(name = "date", required = false) String dateString) {
        Date date = createDateFromDateString(dateString);

        List<Room> rooms = this.roomClient.getAllRooms();
        Map<Long, RoomReservation> roomReservations = new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomId(room.getId());
            roomReservations.put(room.getId(), roomReservation);
        });

        List<Reservation> reservations = this.reservationClient.getAllReservations(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservations.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestClient.getGuest(reservation.getGuestId());
            roomReservation.setGuestId(guest.getId());
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
        });

        return new ArrayList<>(roomReservations.values());
    }

    private Date createDateFromDateString(String dateString) {
        Date date = null;
        if(null != dateString) {
            try {
                date = DATE_FORMAT.parse(dateString);
            } catch (ParseException pe) {
                date = new Date();
            }
        } else {
            date = new Date();
        }
        return date;
    }
}
