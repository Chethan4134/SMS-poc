package com.excel.product_management.dto;

import lombok.*;

import java.time.LocalDate;

/*
 * ProductDto is a Data Transfer Object (DTO) that represents the product details.
 * It is used to transfer module data between layers (e.g., from the service to the controller).
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDto {

    private Integer productId;
    private String productDescription;
    private LocalDate startDate;
    private LocalDate endDate;
}
