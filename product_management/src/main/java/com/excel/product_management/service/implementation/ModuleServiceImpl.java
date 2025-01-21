package com.excel.product_management.service.implementation;

import com.excel.product_management.constants.ProductModuleConstants;
import com.excel.product_management.dto.ModuleDto;
import com.excel.product_management.entity.Module;
import com.excel.product_management.exception.ProductModuleException;
import com.excel.product_management.repository.ModuleRepository;
import com.excel.product_management.service.ModuleService;
import com.excel.product_management.utilities.ModuleUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // Marks this class as a service to be managed by Spring's dependency injection
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;

    /**
     * This method retrieves module details by the module ID.
     * If a module with the provided ID exists, it maps the entity to a DTO and returns it.
     * If the module is not found, it throws a custom exception.
     *
     * @param moduleDto The DTO object containing the moduleId to fetch the module details.
     * @return A ModuleDto containing the details of the found module.
     * @throws ProductModuleException If the module with the given ID does not exist.
     */
    @Override
    public ModuleDto getModuleDetailsById(ModuleDto moduleDto) {

        // Retrieve the module from the database using the moduleId from the provided DTO
        Optional<Module> optional = moduleRepository.findByModuleId(moduleDto.getModuleId());

        // Check if the module was found
        if (optional.isPresent()) {
            Module module = optional.get();
            // Convert the found module entity into a ModuleDto and return it
            return ModuleUtils.getModuleInfo(module);
        }

        // Throw a custom exception if the module with the given ID is not found
        throw new ProductModuleException(ProductModuleConstants.MODULE_ID_DOS_NOT_EXIST);
    }
}
