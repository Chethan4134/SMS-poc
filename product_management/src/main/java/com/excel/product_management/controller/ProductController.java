package com.excel.product_management.controller;

import com.excel.product_management.Response.CommonResponse;
import com.excel.product_management.constants.ProductModuleConstants;
import com.excel.product_management.dto.ModuleDto;
import com.excel.product_management.dto.ProductDto;
import com.excel.product_management.dto.ProductRequestDto;
import com.excel.product_management.exception.ProductModuleException;
import com.excel.product_management.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ProductController handles HTTP requests related to product operations.
 * It processes incoming requests from the frontend, interacts with the service layer,
 * and returns appropriate responses based on the request outcome.
 */
@RestController
@CrossOrigin
@RequestMapping("/search/Product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /***
     * This endpoint retrieves the product details based on the provided product ID.
     * The request must include a valid authentication token in the header.
     *
     * @throws ProductModuleException If the authentication token is missing or invalid.
     */
    @GetMapping("/details")
    public ResponseEntity<CommonResponse<?>> getProductDetails(@RequestBody ProductRequestDto requestDto) {

        CommonResponse<?> response;

        if (requestDto.getModule()) {
            // Fetch module details if the 'module' parameter is present and true
            List<ModuleDto> modulesDto = productService.getProductModuleDetailsById(requestDto.getProductId());
            response = CommonResponse.<List<ModuleDto>>builder()
                    .data(modulesDto)
                    .message(ProductModuleConstants.SUCCESSFULLY_FETCHED_MODULE_DETAILS)
                    .isError(false)
                    .build();
        } else {
            // Default to fetching product details
            ProductDto productDto = productService.getProductDetailsById(ProductDto.builder()
                    .productId(requestDto.getProductId())
                    .build());
            response = CommonResponse.<ProductDto>builder()
                    .data(productDto)
                    .message(ProductModuleConstants.SUCCESSFULLY_FETCHED_PRODUCT_DETAILS)
                    .isError(false)
                    .build();
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}

