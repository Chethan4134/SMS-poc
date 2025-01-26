package com.excel.product_management.service;

import com.excel.product_management.dto.ModuleDto;
import com.excel.product_management.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto getProductDetailsById(ProductDto productDto);
    List<ModuleDto> getProductModuleDetailsById(Integer productId);

}
