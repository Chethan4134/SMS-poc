package com.excel.product_management.controller;

import com.excel.product_management.Response.CommonResponse;
import com.excel.product_management.constants.ProductModuleConstants;
import com.excel.product_management.dto.ModuleDto;
import com.excel.product_management.service.ModuleService;
import lombok.RequiredArgsConstructor;
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
     *
     * @param moduleId The ID of the module whose details are being requested.
     * @return A ResponseEntity containing a CommonResponse with the ModuleDto, along with a success message
     *         if the request is authorized.
     */
    @GetMapping("/byId")
    public ResponseEntity<CommonResponse<ModuleDto>> getModuleDetails(
            @RequestParam("moduleId") Integer moduleId) {

        // Return a successful response containing the module details in a CommonResponse
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(CommonResponse.<ModuleDto>builder()
                        .data(moduleService.getModuleDetailsById(ModuleDto.builder().moduleId(moduleId).build()))
                        .message(ProductModuleConstants.SUCCESSFULLY_FETCHED_MODULE_DETAILS)
                        .isError(false)
                        .build());
    }
}