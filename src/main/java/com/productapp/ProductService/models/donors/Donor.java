package com.productapp.ProductService.models.donors;


import com.productapp.ProductService.models.BaseEntity;
import com.productapp.ProductService.models.events.Event;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Donor extends BaseEntity {

    @Email
    @Column
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToOne
    private Address address;

    @Column
    private Date lastContacted;

    @ManyToMany
    private List<Event> eventsAddressed;

}
