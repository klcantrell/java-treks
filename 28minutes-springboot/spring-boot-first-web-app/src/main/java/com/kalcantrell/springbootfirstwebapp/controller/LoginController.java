package com.kalcantrell.springbootfirstwebapp.controller;


import com.kalcantrell.springbootfirstwebapp.Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginMessage(Parameters params, ModelMap model) {
        model.put("name", params.getName());
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcomePage(Parameters params, ModelMap model) {
        model.put("name", params.getName());
        return "welcome";
    }
}
