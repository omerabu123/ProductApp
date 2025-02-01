package com.productapp.ProductService;

import com.productapp.ProductService.models.currency.Currency;
import com.productapp.ProductService.models.users.User;
import com.productapp.ProductService.repositories.UserDAO;
import com.productapp.ProductService.repositories.currencies.CurrencyDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProductServiceApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ProductServiceApplication.class, args);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		CurrencyDAO currencyDAO = ctx.getBean(CurrencyDAO.class);
		currencyDAO.add(Currency.builder().name("Euro").symbol("EUR").build());
		System.out.println(userDAO.findByUserName("admin"));

	}

}
