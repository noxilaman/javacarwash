package com.noxil.carwash.service;

import com.noxil.carwash.entity.Product;
import com.noxil.carwash.exception.BaseException;
import com.noxil.carwash.exception.ProductException;
import com.noxil.carwash.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(String name,String detail, float price) throws BaseException {
        //Validate
        if(Objects.isNull(name)){
            throw ProductException.nameIsNull();
        }

        if(Objects.isNull(detail)){
            throw ProductException.descIsNull();
        }

        if(Objects.isNull(price)) {
            throw ProductException.priceIsNull();
        }

        if(price == 0){
            throw ProductException.pricenotZero();
        }

        //verify
        if(repository.existsByName(name)){
            throw ProductException.nameDuplicate();
        }


        Product product = new Product();
        product.setName(name);
        product.setDetail(detail);
        product.setPrice(price);

        return repository.save(product);

    }

    public Optional<Product> findByName(String name){
        return repository.findByName(name);
    }
}
