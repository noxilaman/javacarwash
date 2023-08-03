package com.noxil.carwash.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "m_queque")
public class Queque  extends BaseEntity{
    @Column(name = "userId", nullable = false, length = 32)
    private String userId;
    @Column(name = "productId", nullable = false, length = 32)
    private String productId;
    @Column(name = "status", nullable = false, length = 100)
    private String status;
}
