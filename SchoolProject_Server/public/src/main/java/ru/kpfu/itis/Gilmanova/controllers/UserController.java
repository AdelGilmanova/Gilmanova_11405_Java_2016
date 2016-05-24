package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;
import ru.kpfu.itis.Gilmanova.service.UsersService;

/**
 * Created by Adel on 09.04.2016.
 */
@Controller
public class UserController extends BaseController {
    @Autowired
    private UsersService usersService;

    @ResponseBody
    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UsersEntity getUser(@PathVariable("username") String username) {
        return usersService.getUser(username);
    }

}
