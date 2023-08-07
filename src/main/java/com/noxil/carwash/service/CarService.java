package com.noxil.carwash.service;

import com.noxil.carwash.entity.Car;
import com.noxil.carwash.exception.BaseException;
import com.noxil.carwash.exception.CarException;
import com.noxil.carwash.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public Car create(String licensecode, String carsize, String brand, String detail) throws BaseException {
        //validate
        if (Objects.isNull(licensecode)) {
            throw CarException.licenseCodeIsNull();
        }

        if (Objects.isNull(carsize)) {
            throw CarException.carSizeIsNull();
        }

        if (Objects.isNull(brand)) {
            throw CarException.brandIsNull();
        }

        if (Objects.isNull(detail)) {
            throw CarException.detailIsNull();
        }

        //verify
        if (repository.existsByLicensecode(licensecode)) {
            throw CarException.licenseCodeDuplicate();
        }

        Car car = new Car();
        car.setLicensecode(licensecode);
        car.setCarsize(carsize);
        car.setBrand(brand);
        car.setDetail(detail);

        return repository.save(car);
    }

    public Optional<Car> findByLicensecode(String licensecode) {
        return repository.findByLicensecode(licensecode);
    }
}
