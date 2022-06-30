package com.bateivo.tasks.model;

import com.bateivo.tasks.dto.RentalDto;
import com.bateivo.tasks.dto.RentalImageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface RentalMapper {

    RentalMapper INSTANCE = Mappers.getMapper( RentalMapper.class );

    @Mapping(source = "id", target = "rvId")
    //@Mapping(source = "images", target = "otherImageURLs")
    Rental toRental(RentalDto rentalDto);

//    List<String> map(Set<RentalImageDto> rentalImageDtoSet);
//    String map(RentalImageDto rentalImageDto);
}
