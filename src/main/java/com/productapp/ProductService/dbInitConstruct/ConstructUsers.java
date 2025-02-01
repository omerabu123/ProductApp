package com.productapp.ProductService.dbInitConstruct;


import com.productapp.ProductService.models.users.Role;
import com.productapp.ProductService.models.users.User;
import com.productapp.ProductService.models.users.UserPrincipal;
import com.productapp.ProductService.services.BaseEntityAspect;
import com.productapp.ProductService.services.RoleService;
import com.productapp.ProductService.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DependsOn("constructRoles")
public class ConstructUsers {

    @Autowired
    UserService userService;

    @Autowired
    ConstructRoles constructRoles;

    @Autowired
    RoleService roleService;

    @PostConstruct
    private void createUsersInDB() throws Exception {
        User system = new User("system","system",roleService.getRoleByName("ADMIN"));
        UserPrincipal userPrincipal = new UserPrincipal(system);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userPrincipal,"",userPrincipal.getAuthorities()));
        User admin = new User("admin","password",roleService.getRoleByName("ADMIN"));
        User user = new User("user","password",roleService.getRoleByName("USER"));
        List.of(system,admin,user).forEach(u-> {
            try {
                userService.register(u);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

}
