package com.transdev.obt.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
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

    @Column(nullable = false)
    private float price;

}
