package com.noxil.carwash.service;

import com.noxil.carwash.entity.User;
import com.noxil.carwash.exception.BaseException;
import com.noxil.carwash.exception.UserException;
import com.noxil.carwash.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(String email, String username, String password, String firstname, String lastname) throws BaseException {
        //validate
        if(Objects.isNull(email)){
            throw UserException.createEmailIsNull();
        }
        if(Objects.isNull(username)){
            throw UserException.createUsernameIsNull();
        }
        if(Objects.isNull(password)){
            throw UserException.createPasswordIsNull();
        }

        //verify
        if(repository.existsByEmail(email)){
            throw UserException.createEmailDuplicate();
        }
        if(repository.existsByUsername(username)){
            throw UserException.createUsernameDuplicate();
        }

        User entity = new User();
        entity.setEmail(email);
        entity.setUsername(username);
        entity.setPassword(passwordEncoder.encode(password));
        entity.setFirstname(firstname);
        entity.setLastname(lastname);

        return repository.save(entity);
    }
}
