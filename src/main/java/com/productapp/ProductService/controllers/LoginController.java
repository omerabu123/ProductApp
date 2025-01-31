package com.productapp.ProductService.controllers;

import com.productapp.ProductService.models.users.User;
import com.productapp.ProductService.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        try {
            userService.register(user);
            return "Registered!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authHeader, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        try {
            userService.login(authHeader,session);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("failed to log in, "+e.getMessage());
        }
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE,"JSESSIONID="+session.getId()+"; Path=/; HttpOnly")
                .body("logged in");
    }
}
