package com.productapp.ProductService.models.events;

import com.productapp.ProductService.models.BaseEntity;
import com.productapp.ProductService.models.donors.Donor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Event extends BaseEntity {

    @Column
    private String name;

    @Column
    private Date time;

    @ManyToMany
    private List<Donor> donors;
}
