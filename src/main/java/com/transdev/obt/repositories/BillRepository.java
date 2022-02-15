package com.transdev.obt.repositories;

import com.transdev.obt.models.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, Long> {
}
