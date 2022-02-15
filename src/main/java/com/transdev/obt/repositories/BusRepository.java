package com.transdev.obt.repositories;

import com.transdev.obt.models.Bus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends CrudRepository<Bus, Long> {
}
