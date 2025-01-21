package com.excel.product_management.repository;

import com.excel.product_management.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * ModuleRepository is an interface that provides methods to interact with the database for Module entities.
 * It extends JpaRepository, which provides basic CRUD operations and query capabilities.
 */
public interface ModuleRepository extends JpaRepository<Module, Integer> {

    /**
     * Finds a Module by its unique moduleId.
     * This method leverages Spring Data JPA's query generation feature to automatically create a query
     * based on the method name.
     *
     * @param moduleId The unique identifier of the module.
     * @return An Optional containing the Module if found, or empty if not found.
     */
    Optional<Module> findByModuleId(Integer moduleId);
}
