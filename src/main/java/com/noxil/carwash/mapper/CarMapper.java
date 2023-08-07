package com.noxil.carwash.mapper;

import com.noxil.carwash.entity.Car;
import com.noxil.carwash.model.MCarResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    MCarResponse toCarResponse(Car car);
}
