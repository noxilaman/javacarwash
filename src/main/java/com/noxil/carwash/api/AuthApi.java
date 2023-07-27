package com.noxil.carwash.api;

import com.noxil.carwash.business.AuthBusiness;
import com.noxil.carwash.entity.User;
import com.noxil.carwash.exception.BaseException;
import com.noxil.carwash.model.MUserRequest;
import com.noxil.carwash.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class AuthApi {

    //Method
    private final AuthBusiness authbusiness;

    public AuthApi(AuthBusiness authbusiness) {
        this.authbusiness = authbusiness;
    }

    @GetMapping
    public UserResponse main(){
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername("Pkp");
        userResponse.setPassword("asdklajsdlkjasd");
        userResponse.setEmail("pong@g.com");
        userResponse.setFirstname("Parinya");
        userResponse.setLastname("Kornpitak");
        return  userResponse;
    }

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<User> register(@RequestBody MUserRequest request) throws BaseException {
        User response = authbusiness.register(request);
        return ResponseEntity.ok(response);
    }
}
