package com.productapp.ProductService.dbInitConstruct;


import com.productapp.ProductService.models.users.User;
import com.productapp.ProductService.models.users.UserPrincipal;
import com.productapp.ProductService.services.BaseEntityAspect;
import com.productapp.ProductService.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConstructUsers {

    @Autowired
    UserService userService;

    @PostConstruct
    private void createUsersInDB() throws Exception {
        System.out.println("Post Constructing");
        User system = new User("system","system");
        UserPrincipal userPrincipal = new UserPrincipal(system);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userPrincipal,"",userPrincipal.getAuthorities()));
        User admin = new User("admin","password");
        User user = new User("user","password");
        List.of(system,admin,user).forEach(u-> {
            try {
                userService.register(u);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

}
