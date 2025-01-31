package com.productapp.ProductService.controllers;


import com.productapp.ProductService.models.products.Product;
import com.productapp.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product add(@RequestBody Product product){
        try {
            return productService.add(product);
        } catch (UserPrincipalNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
