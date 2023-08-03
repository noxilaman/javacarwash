package com.noxil.carwash.api;

import com.noxil.carwash.business.ProductBusiness;
import com.noxil.carwash.exception.BaseException;
import com.noxil.carwash.model.MProductRequest;
import com.noxil.carwash.model.MProductResponse;
import com.noxil.carwash.model.MUserRequest;
import com.noxil.carwash.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/product")
public class ProductApi {

    private final ProductBusiness productBusiness;

    public ProductApi(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable("id") String id) throws BaseException {
        String response = productBusiness.getProductById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<String> uploadProductPicture(@RequestPart MultipartFile file) throws BaseException, IOException {
        String response = productBusiness.uploadProductPicture(file);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @RequestMapping("/addnew")
    public ResponseEntity<MProductResponse> register(@RequestBody MProductRequest request) throws BaseException {
        MProductResponse response = productBusiness.createNew(request);
        return ResponseEntity.ok(response);
    }
}
