package com.app.service;

import org.springframework.stereotype.Component;

@Component
public class WelcomeService {

    public String retrieveWelcomeMessage() {
        //Complex Method
        return "Good Morning updated";
    }
}