package com.excel.product_management.exception;

import com.excel.product_management.Response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ProductModuleExceptionHandler {

    /**
     * Handles custom ProductModuleException.
     *
     * @param exp The exception object that contains the error details.
     * @return A ResponseEntity containing the error message as a response to the client.
     */
    @ExceptionHandler(ProductModuleException.class)
    public ResponseEntity<CommonResponse<String>> handleProductModuleException(ProductModuleException exp) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(CommonResponse.<String>builder()
                        .message(exp.getMessage())
                        .isError(true)
                        .build());
    }

    /**
     * Handles MethodArgumentTypeMismatchException for invalid parameter types.
     *
     * @param ex The exception object that contains the error details.
     * @return A ResponseEntity containing the error message as a response to the client.
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<CommonResponse<String>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String errorMessage = String.format("Invalid value for parameter '%s': '%s'. Expected type: %s",
                ex.getName(),
                ex.getValue(),
                ex.getRequiredType().getSimpleName());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(CommonResponse.<String>builder()
                        .message(errorMessage)
                        .isError(true)
                        .build());
    }
}