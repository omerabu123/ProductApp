package com.productapp.ProductService.dbInitConstruct;

import com.productapp.ProductService.models.users.Role;
import com.productapp.ProductService.services.RoleService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConstructRoles {

    @Autowired
    RoleService roleService;

    @PostConstruct
    private void createBasicRoles() throws Exception{
        List.of(Role.builder().name("ADMIN").build(),Role.builder().name("USER").build()).forEach(r->{
            roleService.add(r);
        });
    }
}
