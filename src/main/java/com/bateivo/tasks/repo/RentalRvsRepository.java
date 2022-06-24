package com.bateivo.tasks.repo;

import com.bateivo.tasks.dto.Rental;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface RentalRvsRepository extends PageableRepository<Rental, Long> {
}
