package com.excel.product_management.controller;

import com.excel.product_management.Response.CommonResponse;
import com.excel.product_management.constants.ProductModuleConstants;
import com.excel.product_management.dto.ModuleDto;
import com.excel.product_management.exception.ProductModuleException;
import com.excel.product_management.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/search/module")
@RequiredArgsConstructor
public class ModuleController {

    private final ModuleService moduleService;

    /***
     * This endpoint handles the retrieval of module details based on the provided module ID.
     * It also performs token validation to ensure the request is authorized before proceeding.
     *
     * @param moduleId The ID of the module whose details are being requested.
     * @param authToken The authentication token passed in the header to validate the request.
     * @return A ResponseEntity containing a CommonResponse with the ModuleDto, along with a success message
     *         if the request is authorized. If the token is invalid or missing, an exception is thrown.
     */
    @GetMapping("/byId")
    public ResponseEntity<CommonResponse<ModuleDto>> getModuleDetails(
            @RequestParam("moduleId") Integer moduleId,
            @RequestHeader(value = "X-Auth-Token", required = false) String authToken) {

        // Validate the X-Auth-Token to ensure that the request is authorized
        if (authToken == null || !authToken.equals(ProductModuleConstants.TOKEN_VALUE)) {
            // If the token is invalid or missing, throw a ProductModuleException with an appropriate error message
            throw new ProductModuleException(ProductModuleConstants.INVALID_TOKEN);
        } else {

            // Create a ModuleDto object and set the provided moduleId
            ModuleDto moduleDto = new ModuleDto();
            moduleDto.setModuleId(moduleId); // Set the moduleId in ModuleDto

            // Call the service layer to fetch the module details using the moduleDto
            ModuleDto dto = moduleService.getModuleDetailsById(moduleDto);

            // Return a successful response containing the module details in a CommonResponse
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(CommonResponse.<ModuleDto>builder()
                            .data(dto)
                            .message(ProductModuleConstants.SUCCESSFULLY_FETCH_THE_MODULE_DETAILS)
                            .isError(false)
                            .build());
        }
    }
}
