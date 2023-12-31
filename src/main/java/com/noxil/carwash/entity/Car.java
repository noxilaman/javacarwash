package com.noxil.carwash.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "m_car")
public class Car extends BaseEntity{

    @Column(name = "licensecode", nullable = false, unique = true, length = 100)
    private String licensecode;
    @Column(name = "carsize", nullable = false, length = 100)
    private String carsize;
    @Column(name = "brand", nullable = false, length = 100)
    private String brand;
    @Column(name = "detail", nullable = true, length = 100)
    private String detail;
}
