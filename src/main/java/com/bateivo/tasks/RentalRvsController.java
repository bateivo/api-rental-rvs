package com.bateivo.tasks;

import com.bateivo.tasks.dto.Rental;
import com.bateivo.tasks.repo.*;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import java.util.List;

@ExecuteOn(TaskExecutors.IO)
@Controller("/rvs")
public class RentalRvsController {

    protected final IRentalRvsRepository rentalRvsRepository;

    public RentalRvsController(RentalRvsRepository rentalRvsRepository) {

        this.rentalRvsRepository = rentalRvsRepository;
    }

    @Get(value = "/list")
    public List<Rental> list() {

        return rentalRvsRepository.findAll();
    }
}
