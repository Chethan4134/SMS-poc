package com.excel.product_management.dto;

import lombok.*;

import java.time.LocalDate;

/*
 * ModuleDto is a Data Transfer Object (DTO) that represents the module details.
 * It is used to transfer module data between layers (e.g., from the service to the controller).
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModuleDto {

    private Integer moduleId;
    private String moduleDescription;
    private LocalDate startDate;
    private LocalDate endDate;
}
