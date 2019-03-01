package com.kalcantrell.springbootfirstwebapp.Controller;


import com.kalcantrell.springbootfirstwebapp.Parameters;
import com.kalcantrell.springbootfirstwebapp.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    private LoginService service;

    @Autowired
    public LoginController(LoginService service) {
        this.service = service;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginMessage(Parameters params, ModelMap model) {
        model.put("name", params.getName());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcomePage(Parameters params, ModelMap model) {
        boolean isValidUser = service.validateUser(params.getName(), params.getPassword());

        if (!isValidUser) {
            model.put("errorMessage", "Wrong password!");
            return "login";
        }

        model.put("name", params.getName());
        model.put("password", params.getPassword());
        return "welcome";
    }
}
