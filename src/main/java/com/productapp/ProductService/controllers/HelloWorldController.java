package com.productapp.ProductService.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloWorldController {



    @GetMapping
    public String getHello(HttpServletRequest httpServletRequest){
        return "Hello World \n" + httpServletRequest.getSession().getId() +" \n "+ SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
