package com.bateivo.tasks;

import com.bateivo.tasks.model.Rental;
import com.bateivo.tasks.repo.*;
import com.bateivo.tasks.service.IRentalRvsService;
import com.bateivo.tasks.service.RentalRvsService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@ExecuteOn(TaskExecutors.IO)
@Controller()
public class RentalRvsController {

    protected final IRentalRvsService rentalRvsService;

    public RentalRvsController(RentalRvsRepository rentalRvsRepository,
                               RentalRvsService rentalRvsService) {

        this.rentalRvsService = rentalRvsService;
    }

    @Get(value = "/rvs{?args*}")
    List<Rental> list(@Valid SortingAndOrderArguments args,
                      @QueryValue("price[min]") Optional<Integer> priceMin,
                      @QueryValue("price[max]") Optional<Integer> priceMax,
                      @QueryValue("page[limit]") Optional<Integer> limit,
                      @QueryValue("page[offset]") Optional<Integer> offset) {

        if (priceMin.isPresent() && priceMax.isPresent()) {

            args.setPriceMin(priceMin.get());
            args.setPriceMax(priceMax.get());
        }

        if (limit.isPresent() && offset.isPresent()) {

            args.setLimit(limit.get());
            args.setOffset(offset.get());
        }

        return rentalRvsService.getFiltered(args);
    }

    @Get("/rvs/{id}")
    Rental show(Long id) {

        return rentalRvsService.getById(id).orElse(null);
    }
}
