package com.excel.product_management.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductModuleExceptionHandler {

    /***
     * ProductModuleExceptionHandler class centralizes the logic for handling exceptions across the application.
     * It is annotated with @RestControllerAdvice, meaning that it will provide centralized exception handling
     * for all controllers in the application.
     *
     * @param exp The exception object that contains the error details.
     * @return A ResponseEntity containing the error message as a response to the client.
     */
    @ExceptionHandler(ProductModuleException.class) // This annotation indicates that this method handles ProductModuleException
    public ResponseEntity<String> productNotFound(RuntimeException exp){
        // Return a ResponseEntity with the exception's message as the response body
        // The ResponseEntity can be customized with different HTTP status codes if needed.
        return ResponseEntity.ok(exp.getMessage()); // Responding with an HTTP 200 OK status and the error message
    }
}
