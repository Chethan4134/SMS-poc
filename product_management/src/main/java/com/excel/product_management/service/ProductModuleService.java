package com.excel.product_management.service;

import com.excel.product_management.dto.ModuleDto;

import java.util.List;

public interface ProductModuleService {
    List<ModuleDto> getProductModuleDetailsById(Integer productId);


}
