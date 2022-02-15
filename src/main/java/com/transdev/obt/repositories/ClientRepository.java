package com.transdev.obt.repositories;

import com.transdev.obt.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
