package com.noxil.carwash.model;

import lombok.Data;

@Data
public class UserResponse {
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
}
