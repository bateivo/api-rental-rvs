package com.bateivo.tasks;

import com.bateivo.tasks.dto.Rentals;
import com.bateivo.tasks.repo.RentalRvsRepository;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.validation.Valid;
import java.util.List;

@ExecuteOn(TaskExecutors.IO)
@Controller("/rvs")
public class RentalRvsController {

    protected final RentalRvsRepository rentalRvsRepository;

    public RentalRvsController(RentalRvsRepository rentalRvsRepository) {
        this.rentalRvsRepository = rentalRvsRepository;
    }

    @Get("/list")
    public List<Rentals> List(@Valid Pageable pageable) {

        return rentalRvsRepository.findAll(pageable).getContent();

    }
}
