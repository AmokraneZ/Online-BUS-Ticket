package com.transdev.obt.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;
@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Date tripDate;

    @ManyToMany
    private Set<Bus> buses;

    @ManyToOne
    private Client client;

    @OneToOne
    @JoinColumn(nullable = true)
    private Bill bill;
}
