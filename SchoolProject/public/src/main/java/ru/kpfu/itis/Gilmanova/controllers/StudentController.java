package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Logger;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Student;
import ru.kpfu.itis.Gilmanova.model.StudentsEntity;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;
import ru.kpfu.itis.Gilmanova.service.HomeWorkService;
import ru.kpfu.itis.Gilmanova.service.StudentService;

/**
 * Контроллер для отображения домашних заданий ученика
 * Created by Adel on 09.04.2016.
 */
@Controller
@RequestMapping("/student/home_works")
public class StudentController extends BaseController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private HomeWorkService homeWorkService;

    /*
     * Показывает домашние задания ученика
     */
    @Logger
    @Student
    @RequestMapping(method = RequestMethod.GET)
    public String renderStudentPage(ModelMap model) {
        MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = user.getUserEntity().getId();
        StudentsEntity studentsEntity = studentService.getStudentByUserId(userId);
        Integer classId = studentsEntity.getClass_id().getId();
        model.put("home_works", homeWorkService.getHomeWorksByClassId(classId));
        model.put("student", studentService.getStudentByUserId(userId));
        return "student_page";
    }
}
