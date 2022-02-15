package com.transdev.obt.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;
@Data
@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private int nbPlaces;

    @Column(nullable = false)
    private Time departureTime;

    @ManyToMany
    private Set<Reservation> reservations;

}
