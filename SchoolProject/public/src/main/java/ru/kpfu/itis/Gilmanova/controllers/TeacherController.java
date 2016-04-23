package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.Gilmanova.service.TeacherService;

/**
 * ���������� ��� ����������� ������� �������� �������
 * Created by Adel on 17.04.2016.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController extends BaseController{
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(method= RequestMethod.GET)
    public String renderTeacher(ModelMap model){
        //MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //String login = user.getUserEntity().getUsername();
        //Integer userId = user.getUserEntity().getId();
        String login = "tPetrovaLN";
        Integer userId = 1;
        model.put("teacher", teacherService.getTeacher(userId));
        model.put("login", login);
        return "teachers_page";
    }
}