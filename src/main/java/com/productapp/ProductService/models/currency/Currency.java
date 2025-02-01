package com.productapp.ProductService.models.currency;


import com.productapp.ProductService.models.BaseEntity;
import com.productapp.ProductService.models.wallets.WalletCurrency;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Currency extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String symbol;

    @OneToMany
    private List<WalletCurrency> wallets;
}
