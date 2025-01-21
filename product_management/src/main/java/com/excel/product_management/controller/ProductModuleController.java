package com.excel.product_management.controller;

import com.excel.product_management.Response.CommonResponse;
import com.excel.product_management.constants.ProductModuleConstants;
import com.excel.product_management.dto.ModuleDto;
import com.excel.product_management.exception.ProductModuleException;
import com.excel.product_management.service.ProductModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/search/Product/Module")
@RequiredArgsConstructor
public class ProductModuleController {

    // Inject the ProductRepository using constructor injection
    private final ProductModuleService productModuleService;

    /***
     * This endpoint is responsible for fetching the details of a product module based on its product ID.
     * It validates the provided authentication token, and if valid, retrieves the corresponding
     *
     * @param productId The ID of the product for which module details are being requested.
     * @param authToken The authentication token passed in the header for validation.
     * @return ResponseEntity containing a CommonResponse with a list of ModuleDto, along with a success message if valid.
     *         If the token is invalid, a ProductModuleException will be thrown.
     */
    @GetMapping("/byId")
    public ResponseEntity<CommonResponse<List<ModuleDto>>> getProductModuleDetails(
            @RequestParam("productId") Integer productId,
            @RequestHeader(value = "X-Auth-Token", required = false) String authToken) {

        // Validate the X-Auth-Token to ensure the request is authorized
        if (authToken == null || !authToken.equals(ProductModuleConstants.TOKEN_VALUE)) {
            // If the token is invalid or missing, throw a ProductModuleException with an error message
            throw new ProductModuleException(ProductModuleConstants.INVALID_TOKEN);
        } else {
            // If the token is valid, retrieve the product module details by productId from the service layer
            List<ModuleDto> dto = productModuleService.getProductModuleDetailsById(productId);

            // Return a successful response with the retrieved module details
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(CommonResponse.<List<ModuleDto>>builder()
                            .data(dto)
                            .message(ProductModuleConstants.SUCCESSFULLY_FETCH_THE_MODULE_DETAILS)
                            .isError(false)
                            .build());
        }
    }
}
