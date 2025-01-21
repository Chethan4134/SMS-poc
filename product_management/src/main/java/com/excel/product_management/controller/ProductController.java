package com.excel.product_management.controller;

import com.excel.product_management.Response.CommonResponse;
import com.excel.product_management.constants.ProductModuleConstants;
import com.excel.product_management.dto.ProductDto;
import com.excel.product_management.exception.ProductModuleException;
import com.excel.product_management.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
     * @param productId - The unique identifier of the product to fetch details for.
     * @param authToken - The authentication token sent in the request header.
     * @return A ResponseEntity containing a CommonResponse with the product details and a success message.
     * @throws ProductModuleException If the authentication token is missing or invalid.
     */
    @GetMapping("/byId")
    public ResponseEntity<CommonResponse<ProductDto>> getProductDetails(@RequestParam("productId") Integer productId,
                                                                        @RequestHeader(value = "X-Auth-Token", required = false) String authToken) {

        // Validate the authentication token to ensure the request is authorized.
        if (authToken == null || !authToken.equals(ProductModuleConstants.TOKEN_VALUE)) {
            // If the token is invalid or missing, throw a ProductModuleException.
            throw new ProductModuleException(ProductModuleConstants.INVALID_TOKEN);
        } else {
            // If the token is valid, proceed to fetch product details.

            // Create a ProductDto and set the productId for querying.
            ProductDto productDto = new ProductDto();
            productDto.setProductId(productId); // Set the productId in the ProductDto.

            // Call the service to get product details for the given productId.
            ProductDto dto = productService.getProductDetailsById(productDto);

            // Return a successful response with the product details.
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(CommonResponse.<ProductDto>builder()
                            .data(dto)
                            .message(ProductModuleConstants.SUCCESSFULLY_FETCH_THE_PRODUCT_DETAILS)
                            .isError(false)
                            .build());
        }
    }
}
