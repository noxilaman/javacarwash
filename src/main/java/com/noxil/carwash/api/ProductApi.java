package com.noxil.carwash.api;

import com.noxil.carwash.business.ProductBusiness;
import com.noxil.carwash.exception.BaseException;
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
}
