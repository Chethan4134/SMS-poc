package com.excel.product_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Product represents an entity that corresponds to a product in the database.
 * It is mapped to a table in the database using JPA (Java Persistence API).
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Product {

    @Id
    private Integer productId;
    private String productDescription;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToMany
    @JoinTable(
            name = "product_module",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id"))
    private List<Module> modules;
}
