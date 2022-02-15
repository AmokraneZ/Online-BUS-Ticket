package com.transdev.obt.services;

import com.transdev.obt.models.Bus;
import com.transdev.obt.repositories.BusRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    public Optional<Bus> getBus(final Long id) {
        return busRepository.findById(id);
    }

    public Iterable<Bus> getBuses() {
        return busRepository.findAll();
    }

    public void deleteBus(final Long id) {
        busRepository.deleteById(id);
    }

    public Bus saveBus(Bus bus) {
        Bus savedBus = busRepository.save(bus);
        return savedBus;
    }
}
