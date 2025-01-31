package com.productapp.ProductService;

import com.productapp.ProductService.repositories.UserDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProductServiceApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ProductServiceApplication.class, args);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		System.out.println(userDAO.findByUserName("admin"));
	}

}
