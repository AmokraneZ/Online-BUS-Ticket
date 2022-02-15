package com.transdev.obt.controllers;

import com.transdev.obt.models.Bus;
import com.transdev.obt.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BusController {
    @Autowired
    private BusService busService;
    @GetMapping("/buses")
    public Iterable<Bus> getBuses() {
        return busService.getBuses();

    }@GetMapping("/buses/{id}")
    public Optional<Bus> findById(@PathVariable Long id) {
        return busService.getBus(id);
    }

    @PostMapping("/buses/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Bus create(@RequestBody Bus bus) {
        return busService.saveBus(bus);
    }

    @DeleteMapping("/buses/{id}/delete")
    public void delete(@PathVariable Long id) {
        busService.deleteBus(id);
    }
}
