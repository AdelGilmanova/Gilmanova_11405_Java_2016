package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Adel on 30.03.2016.
 */
@Controller
@RequestMapping
public class LoginController extends BaseController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String renderLoginPage(Boolean error) {
        request.setAttribute("error", error);
        return "main_page";
    }

}
