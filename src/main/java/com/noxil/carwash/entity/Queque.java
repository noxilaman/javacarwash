package com.noxil.carwash.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "m_queque")
public class Queque  extends BaseEntity{

    @OneToOne
    @JoinColumn(name="carId")
    private Car car;
    @OneToOne
    @JoinColumn(name="productId")
    private Product product;
    @Column(name = "status", nullable = false, length = 100)
    private String status;
}
