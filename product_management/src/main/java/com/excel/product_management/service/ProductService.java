package com.excel.product_management.service;

import com.excel.product_management.dto.ProductDto;

public interface ProductService {
    ProductDto getProductDetailsById(ProductDto productDto);
}
