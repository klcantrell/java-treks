package com.app.controller;

import com.app.configuration.BasicConfiguration;
import com.app.service.WelcomeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeController {

    private WelcomeService service;
    private final BasicConfiguration basicConfiguration;

    public WelcomeController(WelcomeService welcomeService, BasicConfiguration basicConfiguration) {
        service = welcomeService;
        this.basicConfiguration = basicConfiguration;
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return service.retrieveWelcomeMessage();
    }

    @RequestMapping("/dynamic-configuration")
    public Map dynamicConfiguration() {
        Map map = new HashMap();
        map.put("message", basicConfiguration.getMessage());
        map.put("number", basicConfiguration.getNumber());
        map.put("value", basicConfiguration.value());

        return map;
    }
}