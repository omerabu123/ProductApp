package com.productapp.ProductService.services;

import com.productapp.ProductService.models.BaseEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Date;

@Aspect
@Component
public class BaseEntityAspect {

    @Autowired
    private UserService userService;


    @Before("execution(* org.springframework.data.jpa.repository.JpaRepository+.save(..))")
    public void beforeSaving(JoinPoint joinPoint) throws UserPrincipalNotFoundException {
        Object object = joinPoint.getArgs()[0];
        if (object instanceof BaseEntity baseEntity) {
            System.out.println("id == " +baseEntity.getId());
            if (baseEntity.getId()==null || baseEntity.getId()==0){
                baseEntity.setCreatedBy(userService.getCurrentUser());
            }
            baseEntity.setUpdatedBy(userService.getCurrentUser());
        }
    }
}
