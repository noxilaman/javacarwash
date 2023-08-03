package com.noxil.carwash.repository;

import com.noxil.carwash.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, String> {

    Optional<Product> findByName(String name);

    boolean existsByName(String email);
}
