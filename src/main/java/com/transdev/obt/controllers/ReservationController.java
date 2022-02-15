package com.transdev.obt.controllers;

import com.transdev.obt.models.Reservation;
import com.transdev.obt.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @GetMapping("/reservations")
    public Iterable<Reservation> getReservations() {
        return reservationService.getReservations();
    }

    @GetMapping("/reservations/{id}")
    public Optional<Reservation> findById(@PathVariable Long id) {
        return reservationService.getReservation(id);
    }

    @PostMapping("/reservations/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation create(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    @DeleteMapping("/reservations/{id}/delete")
    public void delete(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
