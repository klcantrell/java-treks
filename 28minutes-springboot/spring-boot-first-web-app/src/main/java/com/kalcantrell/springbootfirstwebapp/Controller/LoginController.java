package com.kalcantrell.springbootfirstwebapp.Controller;


import com.kalcantrell.springbootfirstwebapp.Parameters;
import com.kalcantrell.springbootfirstwebapp.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    private LoginService service;

    @Autowired
    public LoginController(LoginService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginMessage(Parameters params, ModelMap model) {
        model.put("name", "kal");
        return "welcome";
    }
}
