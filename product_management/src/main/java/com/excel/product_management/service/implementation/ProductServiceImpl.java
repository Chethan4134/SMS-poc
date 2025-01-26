package com.excel.product_management.service.implementation;

import com.excel.product_management.constants.ProductModuleConstants;
import com.excel.product_management.dto.ModuleDto;
import com.excel.product_management.dto.ProductDto;
import com.excel.product_management.entity.Module;
import com.excel.product_management.entity.Product;
import com.excel.product_management.exception.ProductModuleException;
import com.excel.product_management.repository.ProductRepository;
import com.excel.product_management.service.ProductService;
import com.excel.product_management.utilities.ProductUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    // Inject the ProductRepository using constructor injection
    private final ProductRepository productRepository;

    /**
     * This method retrieves product details by the product ID.
     * If the product with the provided ID exists, it returns the product details as a ProductDto.
     * If no product is found, it throws a custom exception.
     *
     * @param productDto The DTO object containing the productId to fetch the product details.
     * @return A ProductDto containing the details of the found product.
     * @throws ProductModuleException If the product with the given ID does not exist.
     */
    @Override
    public ProductDto getProductDetailsById(ProductDto productDto) {

        // Attempt to find the product by its ID in the database
        Optional<Product> optional = productRepository.findByProductId(productDto.getProductId());

        // If the product is found
        if (optional.isPresent()) {
            Product product = optional.get();
            // Convert the found product entity to a ProductDto and return it
            return ProductUtils.getProductInfo(product);
        }

        // If the product is not found, throw a custom exception
        throw new ProductModuleException(ProductModuleConstants.PRODUCT_ID_DOES_NOT_EXIST);
    }

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
        Optional<Product> optional = productRepository.findByProductId(productId);

        if (optional.isPresent()) {
            List<Module> modules = optional.get().getModules();

            if (!modules.isEmpty()) {
                return modules.stream().map(m -> ModuleDto.builder()
                        .moduleId(m.getModuleId())
                        .moduleDescription(m.getModuleDescription())
                        .startDate(m.getStartDate())
                        .endDate(m.getEndDate())
                        .build()).toList();
            } else {
                throw new ProductModuleException(ProductModuleConstants.PRODUCT_ID_DOES_NOT_EXIST_IN_MODULE);
            }
        } else {
            throw new ProductModuleException(ProductModuleConstants.PRODUCT_ID_DOES_NOT_EXIST);
        }

    }
}
