package com.productapp.ProductService.repositories.products;


import com.productapp.ProductService.models.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {

    @Autowired
    private ProductRepository productRepository;

    public Product add(Product product){
        return productRepository.save(product);
    }

}
