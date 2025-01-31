package com.productapp.ProductService.repositories;

import com.productapp.ProductService.models.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDAO {

    @Autowired
    private UserRepository userRepository;

    public User add(User user){
        return userRepository.save(user);
    }

    public User findByUserName(String username) {
        Optional<User> opt = userRepository.findByUserName(username);
        return opt.orElse(null);
    }
}
