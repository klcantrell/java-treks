package com.kalcantrell.springbootfirstwebapp.Service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public boolean validateUser(String userId, String password) {
        return userId.equalsIgnoreCase("kal") && password.equalsIgnoreCase("password");
    }

}
