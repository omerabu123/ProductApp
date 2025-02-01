package com.productapp.ProductService.dbInitConstruct;

import com.productapp.ProductService.models.currency.Currency;
import com.productapp.ProductService.repositories.currencies.CurrencyDAO;
import com.productapp.ProductService.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DependsOn("constructUsers")
public class CurrencyConstruct {

    @Autowired
    private ConstructUsers constructUsers;

    @Autowired
    private CurrencyDAO currencyDB;

    @PostConstruct
    public void addCurrencies(){
        Currency usd = Currency.builder()
                .name("Dollar")
                .symbol("USD")
                .build();
        Currency ils = Currency.builder()
                .name("Israeli Shekel")
                .symbol("ILS")
                .build();
        Currency eur = Currency.builder()
                .name("Euro")
                .symbol("EUR")
                .build();
        List.of(usd,ils,eur).forEach(currency -> currencyDB.add(currency));
    }

}
