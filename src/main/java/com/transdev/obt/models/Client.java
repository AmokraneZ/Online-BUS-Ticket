package com.transdev.obt.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany
    private Set<Reservation> reservation;

    public Client() {
    }

}
