package com.transdev.obt.services;

import com.transdev.obt.models.Reservation;
import com.transdev.obt.repositories.ReservationRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Optional<Reservation> getReservation(final Long id) {
        return reservationRepository.findById(id);
    }

    public Iterable<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    public void deleteReservation(final Long id) {
        reservationRepository.deleteById(id);
    }

    public Reservation saveReservation(Reservation reservation) {
        Reservation savedReservation = reservationRepository.save(reservation);
        return savedReservation;
    }

    public float getTotalPrice(Long id){
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        return reservation.getBuses().stream().map(x -> x.getPrice()).reduce(Float.valueOf(0), (a, b) -> a + b);
    }
}
