package com.excel.product_management.utilities;

import com.excel.product_management.dto.ProductDto;
import com.excel.product_management.entity.Product;

public class ProductUtils {

    /**
     * This method takes a Product entity object and converts it into a ProductDto.
     * The ProductDto is a Data Transfer Object that contains specific fields from the Product entity,
     * and it can be used to transfer product-related data in a more lightweight format.
     *
     * @param product The Product entity object containing product details.
     * @return A ProductDto containing the productId, productDescription, startDate, and endDate of the Product.
     */
    public static ProductDto getProductInfo(Product product) {
        // Using the builder pattern to create a ProductDto object and set its values based on the Product entity
        return ProductDto.builder()
                .productId(product.getProductId())
                .productDescription(product.getProductDescription())
                .startDate(product.getStartDate())
                .endDate(product.getEndDate())
                .build(); // Building and returning the ProductDto object
    }
}
