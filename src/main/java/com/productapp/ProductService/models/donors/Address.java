package com.productapp.ProductService.models.donors;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Country country;

    @Column(nullable = false)
    private String streetName;

    @Column
    private int houseNumber;

    @Column
    private int apartment;
}
