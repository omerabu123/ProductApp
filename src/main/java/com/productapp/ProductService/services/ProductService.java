package com.productapp.ProductService.services;

import com.productapp.ProductService.models.products.Product;
import com.productapp.ProductService.repositories.products.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Date;

@Service
public class ProductService {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductDAO productDB;

    public Product add(Product product) throws UserPrincipalNotFoundException {
        product.setCreatedBy(userService.getCurrentUser());
        product.setCreatedAt(new Date());
        product.setUpdatedBy(userService.getCurrentUser());
        product.setUpdatedAt(new Date());
        return productDB.add(product);
    }



}
