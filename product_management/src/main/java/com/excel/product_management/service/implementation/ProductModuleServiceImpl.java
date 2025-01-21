package com.excel.product_management.service.implementation;

import com.excel.product_management.constants.ProductModuleConstants;
import com.excel.product_management.dto.ModuleDto;
import com.excel.product_management.entity.Module;
import com.excel.product_management.entity.Product;
import com.excel.product_management.exception.ProductModuleException;
import com.excel.product_management.repository.ProductRepository;
import com.excel.product_management.service.ProductModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductModuleServiceImpl implements ProductModuleService {

    // Inject the ProductRepository using constructor injection
    private final ProductRepository productModuleRepository;

    /***
     * This method retrieves the module details associated with a given product ID.
     * If a product with the given ID exists and has associated modules, it returns a list of ModuleDto.
     * If the product does not exist or has no associated modules, it throws an exception.
     *
     * @param productId The unique identifier for the product whose modules are to be retrieved.
     * @return A list of ModuleDto containing the module details for the specified product.
     * @throws ProductModuleException If the product is not found or has no associated modules.
     */
    @Override
    public List<ModuleDto> getProductModuleDetailsById(Integer productId) {

        // Attempt to find the product by its ID in the database
        Optional<Product> optional = productModuleRepository.findByProductId(productId);

        // If the product is found
        if (optional.isPresent()) {
            Product product = optional.get(); // Get the product entity
            List<Module> modules = product.getModules(); // Retrieve the list of modules associated with the product

            // If the product has associated modules
            if (!modules.isEmpty()) {
                // Create a list to hold the ModuleDto objects
                List<ModuleDto> collect = new ArrayList<>();
                // Iterate over the modules and convert each to a ModuleDto
                for (Module module : modules) {
                    ModuleDto moduleDto = new ModuleDto();
                    moduleDto.setModuleId(module.getModuleId());
                    moduleDto.setModuleDescription(module.getModuleDescription());
                    moduleDto.setStartDate(module.getStartDate());
                    moduleDto.setEndDate(module.getEndDate());
                    collect.add(moduleDto);
                }
                return collect; // Return the list of ModuleDto objects
            }

            // If the product has no associated modules, throw an exception
            throw new ProductModuleException(ProductModuleConstants.PRODUCT_ID_DOS_NOT_EXIST_IN_MODULE);
        }

        // If the product is not found, throw an exception
        throw new ProductModuleException(ProductModuleConstants.PRODUCT_ID_DOS_NOT_EXIST);
    }
}
