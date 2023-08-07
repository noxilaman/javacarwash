package com.noxil.carwash.api;

import com.noxil.carwash.business.CarBusiness;
import com.noxil.carwash.exception.BaseException;
import com.noxil.carwash.mapper.CarMapper;
import com.noxil.carwash.model.MCarRequest;
import com.noxil.carwash.model.MCarResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/car")
public class CarApi {
    private final CarBusiness carBusiness;

    private final CarMapper carMapper;

    public CarApi(CarBusiness carBusiness, CarMapper carMapper) {
        this.carBusiness = carBusiness;
        this.carMapper = carMapper;
    }

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<MCarResponse> create(@RequestBody MCarRequest request) throws BaseException {
        MCarResponse response = carBusiness.createNew(request);
        return ResponseEntity.ok(response);
    }
}
