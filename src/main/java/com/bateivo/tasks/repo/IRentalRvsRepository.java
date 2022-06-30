package com.bateivo.tasks.repo;

import com.bateivo.tasks.SortingAndOrderArguments;
import com.bateivo.tasks.dto.RentalDto;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface IRentalRvsRepository {

    List<RentalDto> findByFilter(@NotNull SortingAndOrderArguments args);

    Optional<RentalDto> findById(long id);

}
