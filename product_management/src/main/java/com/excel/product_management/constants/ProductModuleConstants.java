package com.excel.product_management.constants;

/*
 * It is designed to hold fixed, predefined values that are related to products.
 * These values can include messages that will be displayed to the user,
 * By centralizing this information in ProductConstants,
 * The program can easily access and manage these values in a consistent and maintainable way.
 */

public interface ProductModuleConstants {

    String PRODUCT_ID_DOS_NOT_EXIST = "product id not exist in the database";
    String MODULE_ID_DOS_NOT_EXIST = "module id not exist in the database";
    String PRODUCT_ID_DOS_NOT_EXIST_IN_MODULE = "module id is not exist in product id in the database";
    String TOKEN_VALUE = "1";
    String INVALID_TOKEN = "invalid token";
    String SUCCESSFULLY_FETCH_THE_MODULE_DETAILS = "successfully fetch the modules details";
    String SUCCESSFULLY_FETCH_THE_PRODUCT_DETAILS = "successfully fetch the product details";
}
