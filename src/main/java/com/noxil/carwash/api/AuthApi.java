package com.noxil.carwash.api;

import com.noxil.carwash.business.AuthBusiness;
import com.noxil.carwash.entity.User;
import com.noxil.carwash.exception.BaseException;
import com.noxil.carwash.mapper.UserMapper;
import com.noxil.carwash.model.MLoginRequest;
import com.noxil.carwash.model.MUserRequest;
import com.noxil.carwash.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class AuthApi {

    //Method
    private final AuthBusiness authbusiness;

    private final UserMapper userMapper;

    public AuthApi(AuthBusiness authbusiness, UserMapper userMapper) {
        this.authbusiness = authbusiness;
        this.userMapper = userMapper;
    }

    @GetMapping
    public UserResponse main(){
        User user = new User();

        return  userMapper.toUserResponse(user) ;
    }

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody MUserRequest request) throws BaseException {
        UserResponse response = authbusiness.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MLoginRequest request) throws BaseException {
        String response = authbusiness.login(request);
        return ResponseEntity.ok(response);
    }
}
