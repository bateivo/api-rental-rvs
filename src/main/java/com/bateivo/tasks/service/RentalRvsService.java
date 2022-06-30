package com.bateivo.tasks.service;

import com.bateivo.tasks.SortingAndOrderArguments;
import com.bateivo.tasks.dto.RentalDto;
import com.bateivo.tasks.dto.RentalImageDto;
import com.bateivo.tasks.model.Rental;
import com.bateivo.tasks.model.RentalMapper;
import com.bateivo.tasks.repo.IRentalRvsRepository;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Singleton
public class RentalRvsService implements IRentalRvsService{

    protected final IRentalRvsRepository rentalRvsRepository;

    public RentalRvsService(IRentalRvsRepository rentalRvsRepository) {

        this.rentalRvsRepository = rentalRvsRepository;
    }

    public List<Rental> getFiltered(SortingAndOrderArguments args) {

        List<Rental> rentalsResult = new ArrayList<>();

        List<RentalDto> rentals = rentalRvsRepository.findByFilter(args);

        for (RentalDto rental : rentals) {

            Rental result = RentalMapper.INSTANCE.toRental(rental);

            result.setOtherImageURLs(getImageUrls(rental.getImages()));

            rentalsResult.add(result);
        }

        return rentalsResult;
    }

    public Optional<Rental> getById(long id) {

        Optional<RentalDto> rental = rentalRvsRepository.findById(id);

        if (rental.isPresent()) {

            Rental result = RentalMapper.INSTANCE.toRental(rental.get());

            result.setOtherImageURLs(getImageUrls(rental.get().getImages()));

            return Optional.of(result);
        }

        return Optional.empty();
    }

    private List<String> getImageUrls (Set<RentalImageDto> imageDtos) {

        List<String> imageUrls = new ArrayList<>();

        for (RentalImageDto image : imageDtos) {

            imageUrls.add(image.getUrl());
        }

        return imageUrls;
    }

}
