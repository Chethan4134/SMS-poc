package com.excel.product_management.exception;

/***
 * Custom Exception class to handle specific exceptions related to product and module operations.
 * This class extends RuntimeException to allow unchecked exceptions.
 */
public class ProductModuleException extends RuntimeException {
    // A unique identifier for this class, used for serialization
    private static final long serialVersionUID = 1L;

    /**
     * Constructor that accepts a custom error message for the exception.
     * This message can be used to provide more details about the exception when thrown.
     *
     * @param message The error message associated with this exception.
     */
    public ProductModuleException(String message){
        // Pass the error message to the superclass (RuntimeException) constructor
        super(message);
    }
}

