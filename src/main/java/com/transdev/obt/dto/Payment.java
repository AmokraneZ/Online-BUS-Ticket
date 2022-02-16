package com.transdev.obt.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Component
public class Payment {
    private long reservation_id;
    private String paypalMail;
    private Long creditCardNumber;
    private Date expirationDate;
}
