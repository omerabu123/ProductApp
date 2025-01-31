package com.productapp.ProductService.services;

import com.productapp.ProductService.models.users.User;
import com.productapp.ProductService.models.users.UserPrincipal;
import com.productapp.ProductService.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDB;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDB.findByUserName(username);
        if (user==null)
            throw new UsernameNotFoundException("No such user");
        return new UserPrincipal(user);
    }
}
