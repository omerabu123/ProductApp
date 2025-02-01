package com.productapp.ProductService.services;

import com.productapp.ProductService.models.users.Role;
import com.productapp.ProductService.repositories.roles.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDAO roleDB;

    public Role add(Role role){
        return roleDB.add(role);
    }

    public Role getRoleByName(String name){
        return roleDB.findByName(name);
    }
}
