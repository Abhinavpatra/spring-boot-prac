package com.example.createstore.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

// TODO: add extra validations to all the properties of the class

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "customer_name")
    private String customer_name;

    @Column(nullable = false, name = "customer_email")
    private String customer_email;

    @Column(nullable = false)
    private String status;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // will run before it saves something to the DB
    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }

    // relations
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

}
