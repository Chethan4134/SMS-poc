package com.excel.product_management.constants;

/*
 * This interface holds fixed, predefined values related to products.
 * These values include messages that will be displayed to the user.
 * By centralizing this information in ProductModuleConstants,
 * the program can easily access and manage these values in a consistent and maintainable way.
 */
public interface ProductModuleConstants {

    String PRODUCT_ID_DOES_NOT_EXIST = "Product ID does not exist in the database.";
    String MODULE_ID_DOES_NOT_EXIST = "Module ID does not exist in the database.";
    String PRODUCT_ID_DOES_NOT_EXIST_IN_MODULE = "Product ID does not exist in the specified module.";
    String TOKEN_VALUE = "1"; // Consider using a more descriptive name if this is a constant token value.
    String INVALID_TOKEN = "Invalid token.";
    String SUCCESSFULLY_FETCHED_MODULE_DETAILS = "Successfully fetched the module details.";
    String SUCCESSFULLY_FETCHED_PRODUCT_DETAILS = "Successfully fetched the product details.";
    String PRODUCT_ID_CANNOT_BE_NULL = "Product ID cannot be null.";
}