package com.example.createstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

// adding annotations for adding functionalities
// then we can also add annotations at the field level
@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "product_name")
    private String name;

    private String description;
    private String category;

    
    @Column(nullable = false)
    @DecimalMin(value="0.0", inclusive = false, message = "Price cannot be 0")
    @NotNull(message = "Price is required")
    private BigDecimal price;

    @NotNull(message = "Stock Quantity is required")
    @Min(value = 0, message = "Stock quantity cannot be less than 0")
    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    // TODO: relations
    @JsonIgnore // adding this prop, ensures that we dont get all the orders associated with the product
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

}
