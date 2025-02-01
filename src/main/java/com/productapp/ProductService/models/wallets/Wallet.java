package com.productapp.ProductService.models.wallets;


import com.fasterxml.jackson.databind.ser.Serializers;
import com.productapp.ProductService.models.BaseEntity;
import com.productapp.ProductService.models.currency.Currency;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Wallet extends BaseEntity {

    @Column
    private String name;

    @OneToMany(mappedBy = "wallet")
    private List<WalletCurrency> currencies;
}
