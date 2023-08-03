package com.noxil.carwash.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "m_product")
public class Product extends BaseEntity{
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "desc", nullable = false, length = 255)
    private String desc;
    @Column(name = "price", nullable = false)
    private float price;
}
