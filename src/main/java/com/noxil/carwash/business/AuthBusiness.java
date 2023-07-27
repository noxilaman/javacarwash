package com.noxil.carwash.business;

import com.noxil.carwash.entity.User;
import com.noxil.carwash.exception.BaseException;
import com.noxil.carwash.exception.UserException;
import com.noxil.carwash.model.MUserRequest;
import com.noxil.carwash.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthBusiness {

    private final UserService userService;

    public AuthBusiness(UserService userService) {
        this.userService = userService;
    }

    public User register(MUserRequest request) throws BaseException {
        if (request == null) {
            throw UserException.requestIsNull();
        }

        User user = userService.create(request.getEmail(), request.getUsername(), request.getPassword(), request.getFirstname(), request.getLastname());


        return user;
    }
}
