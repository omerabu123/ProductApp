package com.productapp.ProductService.repositories.products;

import com.productapp.ProductService.models.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
