package com.noxil.carwash.repository;

import com.noxil.carwash.entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarRepository  extends CrudRepository<Car, String> {
    Optional<Car> findByLicensecode(String licensecode);

    boolean existsByLicensecode(String licensecode);
}
