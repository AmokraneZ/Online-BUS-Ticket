package com.transdev.obt.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Reservation reservation;

    @Column
    private String paypalMail;

    @Column
    private Long creditCardNumber;

    @Column
    private Date expirationDate;
}
