package com.productapp.ProductService.repositories.roles;

import com.productapp.ProductService.models.users.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleDAO {

    @Autowired
    private RoleRepository roleRepository;

    public Role add(Role role){
        return roleRepository.save(role);
    }

    public Role findByName(String name) {
        Optional<Role> opt =roleRepository.findByName(name);
        return opt.orElse(null);
    }
}
