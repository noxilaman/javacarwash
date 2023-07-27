package com.noxil.carwash.business;

import com.noxil.carwash.entity.User;
import com.noxil.carwash.exception.BaseException;
import com.noxil.carwash.exception.UserException;
import com.noxil.carwash.mapper.UserMapper;
import com.noxil.carwash.model.MLoginRequest;
import com.noxil.carwash.model.MUserRequest;
import com.noxil.carwash.model.UserResponse;
import com.noxil.carwash.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AuthBusiness {

    private final UserService userService;

    private final UserMapper userMapper;

    public AuthBusiness(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public UserResponse register(MUserRequest request) throws BaseException {
        if (request == null) {
            throw UserException.requestIsNull();
        }

        User user = userService.create(request.getEmail(), request.getUsername(), request.getPassword(), request.getFirstname(), request.getLastname());


        return userMapper.toUserResponse(user);
    }

    public String login(MLoginRequest request) throws BaseException{
        //validate
        if(Objects.isNull(request.getEmail()) && Objects.isNull(request.getUsername())){
            throw UserException.loginUsernameOrEmailIsnull();
        }

        //verify DB
        Optional<User> opt = null;
        if(Objects.isNull(request.getEmail())){
            opt = userService.findByUsername(request.getUsername());
        }else{
            opt = userService.findByEmail(request.getEmail());
        }

        if(opt.isEmpty()) {
            throw UserException.loginFail();
        }

        User user = opt.get();
        if(!userService.matchPassword(request.getPassword(),user.getPassword())){
            throw UserException.loginFail();
        }

        String token = " ";
        return token;
    }
}
