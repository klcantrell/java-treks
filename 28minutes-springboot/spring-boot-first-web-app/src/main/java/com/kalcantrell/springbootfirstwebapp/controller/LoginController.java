package com.kalcantrell.springbootfirstwebapp.controller;


import com.kalcantrell.springbootfirstwebapp.Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String loginMessage(Parameters params, ModelMap model) {
        model.put("name", params.getName());
        return "login";
    }
}
