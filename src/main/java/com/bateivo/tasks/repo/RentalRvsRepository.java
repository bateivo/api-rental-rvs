package com.bateivo.tasks.repo;

import com.bateivo.tasks.dto.Rentals;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.PageableRepository;

@JdbcRepository
public interface RentalRvsRepository extends PageableRepository<Rentals, Long> {

}
