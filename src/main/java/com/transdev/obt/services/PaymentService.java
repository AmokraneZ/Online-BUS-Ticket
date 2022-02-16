package com.transdev.obt.services;

import com.transdev.obt.dto.Payment;
import com.transdev.obt.models.Bill;
import com.transdev.obt.models.Reservation;
import com.transdev.obt.repositories.BillRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Data
@Service
public class PaymentService {
    @Autowired
    ReservationService reservationService;
    @Autowired
    BillRepository billRepository;

    public Bill payment(Payment payment){
        Reservation reservation = reservationService.getReservation(payment.getReservation_id()).orElse(null);
        float amount = reservationService.getTotalPrice(payment.getReservation_id());
        if (amount > 100){
            amount = (float) (0.95 * amount);
        }
        Bill bill = new Bill();
        bill.setReservation(reservation);
        String paypalMail = payment.getPaypalMail();
        if (null != paypalMail){
            bill.setPaypalMail(paypalMail);
        } else {
            long creditCardNumber = payment.getCreditCardNumber();
            Date expirationDate = payment.getExpirationDate();
            bill.setCreditCardNumber(creditCardNumber);
            bill.setExpirationDate(expirationDate);
        }
        bill.setAmount(amount);
        billRepository.save(bill);
        return bill;
    }

}
