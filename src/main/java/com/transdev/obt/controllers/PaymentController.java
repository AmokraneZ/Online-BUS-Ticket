package com.transdev.obt.controllers;

import com.transdev.obt.dto.Payment;
import com.transdev.obt.models.Bill;
import com.transdev.obt.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @PostMapping("/payment/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Bill create(@RequestBody Payment payment) {
        return paymentService.payment(payment);
    }
}
