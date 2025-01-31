package com.productapp.ProductService;


import com.productapp.ProductService.models.users.User;
import com.productapp.ProductService.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructUsers {

    @Autowired
    UserService userService;

    @PostConstruct
    private void createUsersInDB() throws Exception {
        System.out.println("Post Constructing");
        User admin = new User("admin","password");
        User user = new User("user","password");
        userService.register(admin);
        userService.register(user);
    }
}
