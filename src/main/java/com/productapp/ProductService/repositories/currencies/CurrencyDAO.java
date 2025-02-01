package com.productapp.ProductService.repositories.currencies;


import com.productapp.ProductService.models.currency.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CurrencyDAO {

    @Autowired
    private CurrencyRepository currencyRepository;


    public Currency add(Currency currency){
        return currencyRepository.save(currency);
    }
}
