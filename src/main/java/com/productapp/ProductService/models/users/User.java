package com.productapp.ProductService.models.users;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @ManyToOne
    private Role role;

    public User(String userName,String password,Role role){
        this.userName=userName;
        this.password=password;
        this.role=role;
    }

}
