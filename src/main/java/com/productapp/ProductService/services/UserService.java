package com.productapp.ProductService.services;

import com.productapp.ProductService.models.users.User;
import com.productapp.ProductService.models.users.UserPrincipal;
import com.productapp.ProductService.repositories.UserDAO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Base64;

@Service
public class UserService {

    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Autowired
    private UserDAO userDB;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public void register(User user) throws Exception {
        if (getUserByUserName(user.getUserName())!=null)
            throw new Exception("already exists");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        this.userDB.add(user);
    }

    public User getUserByUserName(String userName){
        return userDB.findByUserName(userName);
    }

    public String login(String authHeader, HttpSession httpSession) throws Exception {
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new Exception("Missing or invalid Authorization header");
        }
        // Decode Basic Auth credentials
        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);
        String[] values = credentials.split(":", 2);
        if (values.length != 2) {
            throw new Exception("Invalid argument");
        }
        String username = values[0];
        String password = values[1];

        try {
            // Authenticate using Spring Security
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(username, password);
            Authentication authentication = authenticationManager.authenticate(authToken);

            // Set authenticated user in SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Create session
            httpSession.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

            return httpSession.getId();
        } catch (AuthenticationException e){
            throw new Exception(e.getMessage());
        }
    }

    public User getCurrentUser() throws UserPrincipalNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserPrincipal)
            return ((UserPrincipal) authentication.getPrincipal()).getUser();
        else
            throw new UserPrincipalNotFoundException("");
    }
}
