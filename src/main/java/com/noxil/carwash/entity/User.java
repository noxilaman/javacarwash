package com.noxil.carwash.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "m_user")
public class User extends BaseEntity {

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    @JsonIgnore
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;
    @Column(name = "firstname", nullable = true, length = 100)
    private String firstname;
    @Column(name = "lastname", nullable = true, length = 100)
    private String lastname;

}
