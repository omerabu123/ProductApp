package com.productapp.ProductService.models.donations;

import com.productapp.ProductService.models.BaseEntity;
import com.productapp.ProductService.models.currency.Currency;
import com.productapp.ProductService.models.donors.Country;
import com.productapp.ProductService.models.events.Event;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Donation extends BaseEntity {

    @ManyToOne
    private Currency currency;

    @Column
    private int amount;

    @Column
    private Platform platform;

    @Column
    private Date time;

    @Column
    private Event cause;

    @ManyToOne
    private Country country;

}
