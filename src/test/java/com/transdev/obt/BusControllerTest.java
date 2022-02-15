package com.transdev.obt;

import com.transdev.obt.services.BusService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BusControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testGetBuses() throws Exception {
        mockMvc.perform(get("/buses"))
                .andExpect(status().isOk());
    }}
