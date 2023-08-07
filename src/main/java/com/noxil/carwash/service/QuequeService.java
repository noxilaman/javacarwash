package com.noxil.carwash.service;

import com.noxil.carwash.entity.Car;
import com.noxil.carwash.entity.Product;
import com.noxil.carwash.entity.Queque;
import com.noxil.carwash.entity.User;
import com.noxil.carwash.repository.QuequeRepository;
import org.springframework.stereotype.Service;

@Service
public class QuequeService {

    private final QuequeRepository repository;

    public QuequeService(QuequeRepository repository) {
        this.repository = repository;
    }

    public Queque create(Car car, Product product, String status){
        Queque entity = new Queque();
        entity.setCar(car);
        entity.setProduct(product);
        entity.setStatus(status);

        return entity;
    }
}
