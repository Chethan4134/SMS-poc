package com.excel.product_management.repository;

import com.excel.product_management.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * ProductRepository is an interface that provides methods to interact with the database for Product entities.
 * It extends JpaRepository, which provides basic CRUD operations and query capabilities.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    /***
     * JpaRepository is used to fetch the database for Product entities.
     * This method automatically generates a query based on the method name.
     * It is used to find a Product by its unique productId.
     *
     * @param productId The unique identifier of the product.
     * @return An Optional containing the Product if found, or an empty Optional if no product with the given ID is found.
     */
    Optional<Product> findByProductId(Integer productId);
}
