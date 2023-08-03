package com.noxil.carwash.api;

import com.noxil.carwash.exception.BaseException;
import com.noxil.carwash.model.MUserRequest;
import com.noxil.carwash.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/queque")
public class QuequeApi {

    @GetMapping("/all")
    public ResponseEntity<String> getAllQueque() throws BaseException {

        String result = "Ok";

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<String> addQueque(@RequestBody MUserRequest request) throws BaseException {

        String result = "Ok";
        return ResponseEntity.ok(result);
    }
}
