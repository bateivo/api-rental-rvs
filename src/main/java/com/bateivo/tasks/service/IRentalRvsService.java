package com.bateivo.tasks.service;

import com.bateivo.tasks.SortingAndOrderArguments;
import com.bateivo.tasks.dto.RentalDto;
import com.bateivo.tasks.model.Rental;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface IRentalRvsService {

    List<Rental> getFiltered(@NotNull SortingAndOrderArguments args);

    Optional<Rental> getById(long id);
}
