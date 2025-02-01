package com.productapp.ProductService.repositories.currencies;

import com.productapp.ProductService.models.currency.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency,Long> {
}
