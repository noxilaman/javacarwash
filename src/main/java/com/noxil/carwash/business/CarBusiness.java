package com.noxil.carwash.business;


import com.noxil.carwash.entity.Car;
import com.noxil.carwash.exception.BaseException;
import com.noxil.carwash.exception.CarException;
import com.noxil.carwash.mapper.CarMapper;
import com.noxil.carwash.model.MCarRequest;
import com.noxil.carwash.model.MCarResponse;
import com.noxil.carwash.service.CarService;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CarBusiness {

    private final CarService carService;

    private final CarMapper carMapper;

    public CarBusiness(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    public MCarResponse createNew(MCarRequest request) throws BaseException {
        if (request == null) {
            throw CarException.licenseCodeIsNull();
        }

        Car car = carService.create(request.getLicensecode(), request.getCarsize(), request.getBrand(), request.getDetail());

        return carMapper.toCarResponse(car);
    }

    public Optional<Car> getCarByLicensecode(String licensecode) throws BaseException {
        if (Objects.isNull(licensecode)) {
            throw CarException.licenseCodeIsNull();
        }

        Optional<Car> cars = carService.findByLicensecode(licensecode);

        if (Objects.isNull(cars)) {
            throw CarException.licenseCodeIsNull();
        }

        return cars;
    }
}
