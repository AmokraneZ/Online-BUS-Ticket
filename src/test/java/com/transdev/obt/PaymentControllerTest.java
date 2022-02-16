package com.transdev.obt;
import static org.hamcrest.CoreMatchers.is;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transdev.obt.dto.Payment;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PaymentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testCreatePaymentOverHunderdWithPaypal() throws Exception {
        Payment payment = new Payment();
        payment.setReservation_id(1);
        payment.setPaypalMail("toto@titi.com");
        mockMvc.perform(MockMvcRequestBuilders.post("/payment/create")
                        .content(asJsonString(payment))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(201))
                .andExpect(jsonPath("reservation.id", is(1)))
                .andExpect(jsonPath("reservation.tripDate", is("2022-02-16")))
                .andExpect(jsonPath("reservation.buses[0].id", is(2)))
                .andExpect(jsonPath("reservation.buses[0].nbPlaces", is(50)))
                .andExpect(jsonPath("reservation.buses[0].departureTime", is("09:30:00")))
                .andExpect(jsonPath("reservation.buses[0].price", is(80.0)))
                .andExpect(jsonPath("reservation.buses[1].id", is(1)))
                .andExpect(jsonPath("reservation.buses[1].nbPlaces", is(30)))
                .andExpect(jsonPath("reservation.buses[1].departureTime", is("09:00:00")))
                .andExpect(jsonPath("reservation.buses[1].price", is(50.0)))
                .andExpect(jsonPath("reservation.client.id", is(1)))
                .andExpect(jsonPath("reservation.client.email", is("TOTO@TITI.com")))
                .andExpect(jsonPath("reservation.client.name", is("TOTO")))
                .andExpect(jsonPath("paypalMail", is("toto@titi.com")))
                .andExpect(jsonPath("creditCardNumber").value(IsNull.nullValue()))
                .andExpect(jsonPath("expirationDate").value(IsNull.nullValue()))
                .andExpect(jsonPath("amount", is(123.5)));
    }
    @Test
    public void testCreatePaymentUnderHunderdWithoutPaypal() throws Exception {
        Payment payment = new Payment();
        payment.setReservation_id(2);
        payment.setCreditCardNumber(123456789L);
        payment.setExpirationDate(parseDate("2023-09-08"));

        mockMvc.perform(MockMvcRequestBuilders.post("/payment/create")
                        .content(asJsonString(payment))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(201))
                .andExpect(jsonPath("reservation.id", is(3)))
                .andExpect(jsonPath("reservation.tripDate", is("2022-02-16")))
                .andExpect(jsonPath("reservation.buses[1].id", is(4)))
                .andExpect(jsonPath("reservation.buses[1].nbPlaces", is(50)))
                .andExpect(jsonPath("reservation.buses[1].departureTime", is("09:30:00")))
                .andExpect(jsonPath("reservation.buses[1].price", is(40.0)))
                .andExpect(jsonPath("reservation.buses[0].id", is(3)))
                .andExpect(jsonPath("reservation.buses[0].nbPlaces", is(30)))
                .andExpect(jsonPath("reservation.buses[0].departureTime", is("09:00:00")))
                .andExpect(jsonPath("reservation.buses[0].price", is(50.0)))
                .andExpect(jsonPath("reservation.client.id", is(1)))
                .andExpect(jsonPath("reservation.client.email", is("TOTO@TITI.com")))
                .andExpect(jsonPath("reservation.client.name", is("TOTO")))
                .andExpect(jsonPath("paypalMail").value(IsNull.nullValue()))
                .andExpect(jsonPath("creditCardNumber", is(123456789)))
                .andExpect(jsonPath("expirationDate",is("2023-09-08")))
                .andExpect(jsonPath("amount", is(90.0)));
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
