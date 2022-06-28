package com.bateivo.tasks.repo;

import com.bateivo.tasks.SortingAndOrderArguments;
import com.bateivo.tasks.dto.Rental;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface IRentalRvsRepository {

    List<Rental> findAll(@NotNull SortingAndOrderArguments args);

}
