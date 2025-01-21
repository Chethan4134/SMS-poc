package com.excel.product_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Module represents an entity that corresponds to a module in the database.
 * It is mapped to a table in the database using JPA (Java Persistence API).
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Module {

    @Id
    private Integer moduleId;
    private String moduleDescription;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToMany(mappedBy = "modules")
    private List<Product> products;

}
