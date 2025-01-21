package com.excel.product_management.utilities;

import com.excel.product_management.dto.ModuleDto;
import com.excel.product_management.entity.Module;

public class ModuleUtils {

    /**
     * This method takes a Module entity object and converts it into a ModuleDto.
     * The ModuleDto is a Data Transfer Object that contains specific fields from the Module entity,
     * which can be used for communication between different layers or services.
     *
     * @param module The Module entity object that contains module details.
     * @return A ModuleDto containing the moduleId, moduleDescription, startDate, and endDate of the Module.
     */
    public static ModuleDto getModuleInfo(Module module) {
        // Using the builder pattern to create a ModuleDto object and set its values based on the Module entity
        return ModuleDto.builder()
                .moduleId(module.getModuleId())
                .moduleDescription(module.getModuleDescription())
                .startDate(module.getStartDate())
                .endDate(module.getEndDate())
                .build(); // Building and returning the ModuleDto object
    }
}
