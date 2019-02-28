package com.kalcantrell.springbootfirstwebapp.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public boolean validateUser(String userId, String password) {
        return userId.equalsIgnoreCase("kal") && password.equalsIgnoreCase("password");
    }

}
