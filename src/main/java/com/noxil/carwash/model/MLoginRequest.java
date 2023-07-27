package com.noxil.carwash.model;

import lombok.Data;

@Data
public class MLoginRequest {
    private String email;
    private String username;
    private String password;
}
