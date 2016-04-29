package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Logger;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Teacher;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;
import ru.kpfu.itis.Gilmanova.service.TeacherService;

/**
 * Контроллер для отображения личного кабинета учителя
 * Created by Adel on 17.04.2016.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController extends BaseController{
    @Autowired
    private TeacherService teacherService;

    @Logger
    @Teacher
    @RequestMapping(method= RequestMethod.GET)
    public String renderTeacher(ModelMap model){
        MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUserEntity().getUsername();
        Integer userId = user.getUserEntity().getId();
        model.put("teacher", teacherService.getTeacherByUserId(userId));
        model.put("login", login);
        return "teachers_page";
    }
}
