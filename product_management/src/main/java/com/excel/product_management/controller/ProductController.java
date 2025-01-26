package com.excel.product_management.controller;

import com.excel.product_management.Response.CommonResponse;
import com.excel.product_management.constants.ProductModuleConstants;
import com.excel.product_management.dto.ModuleDto;
import com.excel.product_management.dto.ProductDto;
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
     * @param productId - The unique identifier of the product to fetch details for.* @return A ResponseEntity containing a CommonResponse with the product details and a success message.
     * @throws ProductModuleException If the authentication token is missing or invalid.
     */
    @GetMapping("/byId")
    public ResponseEntity<CommonResponse<ProductDto>> getProductDetails(@RequestParam("productId") Integer productId) {

            if (productId != null) {
                return ResponseEntity.status(HttpStatus.ACCEPTED)
                        .body(CommonResponse.<ProductDto>builder()
                                .data(productService.getProductDetailsById(ProductDto.builder()
                                        .productId(productId)
                                        .build()))
                                .message(ProductModuleConstants.SUCCESSFULLY_FETCHED_PRODUCT_DETAILS)
                                .isError(false)
                                .build());
            }
        throw new ProductModuleException(ProductModuleConstants.PRODUCT_ID_CANNOT_BE_NULL);

    }

    /***
     * This endpoint is responsible for fetching the details of a product module based on its product ID.
     * It validates the provided authentication token, and if valid, retrieves the corresponding
     *
     * @param productId The ID of the product for which module details are being requested.
     * @return ResponseEntity containing a CommonResponse with a list of ModuleDto, along with a success message if valid.
     *         If the token is invalid, a ProductModuleException will be thrown.
     */
    @GetMapping("/module/byId")
    public ResponseEntity<CommonResponse<List<ModuleDto>>> getProductModuleDetails(
            @RequestParam("productId") Integer productId) {

            // If the token is valid, retrieve the product module details by productId from the service layer
            List<ModuleDto> dto = productService.getProductModuleDetailsById(productId);

            // Return a successful response with the retrieved module details
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(CommonResponse.<List<ModuleDto>>builder()
                            .data(dto)
                            .message(ProductModuleConstants.SUCCESSFULLY_FETCHED_MODULE_DETAILS)
                            .isError(false)
                            .build());
        }
    }

