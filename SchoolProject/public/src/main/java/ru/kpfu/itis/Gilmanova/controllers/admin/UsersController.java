package ru.kpfu.itis.Gilmanova.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Admin;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Logger;
import ru.kpfu.itis.Gilmanova.controllers.BaseController;
import ru.kpfu.itis.Gilmanova.service.ClassesService;
import ru.kpfu.itis.Gilmanova.service.StudentService;
import ru.kpfu.itis.Gilmanova.service.TeacherService;

/**
 * Created by Adel on 26.04.2016.
 */
@Controller
@RequestMapping("/admin")
public class UsersController extends BaseController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClassesService classesService;

    /*
     * Таблица с учащимися
     */
    @Logger
    @Admin
    @RequestMapping(value = "/students_list", method = RequestMethod.GET)
    public String renderStudentsTable(ModelMap model) {
        model.put("students", studentService.getAllStudents());
        model.put("classes", classesService.getAllClasses());
        return "admin/student_info/students_list";
    }

    /*
     * Таблица с преподавателями
     */
    @Logger
    @Admin
    @RequestMapping(value = "/teacher_list", method = RequestMethod.GET)
    public String renderTeachersList(ModelMap model) {
        model.put("teachers", teacherService.getAllTeachers());
        return "admin/teacher_info/teachers_list";
    }

    /*
     * Возвращает учащихся с нужного класса AJAX
     */
    @Logger
    @Admin
    @RequestMapping(value = "/searchClass", method = RequestMethod.GET)
    public String searchClass(@RequestParam(required = false) String classId,
                              ModelMap model) {
        model.put("students", studentService.getStudentByClass(Integer.parseInt(classId)));
        return "admin/student_info/ajaxStudentsResult";
    }

    /*
     * Возвращает учащихся с нужным именем AJAX
     */
    @Logger
    @Admin
    @RequestMapping(value = "/searchByName", method = RequestMethod.GET)
    public String searchByName(@RequestParam(required = false) String name,
                               ModelMap model) {
        model.put("students", studentService.getStudentByName(name));
        return "admin/student_info/ajaxStudentsResult";
    }

    /*
     * Возвращает преподов с нужным именем AJAX
     */
    @Logger
    @Admin
    @RequestMapping(value = "/searchTeacherByName", method = RequestMethod.GET)
    public String searchTeacherByName(@RequestParam(required = false) String name,
                                      ModelMap model) {
        model.put("teachers", teacherService.getTeacherByName(name));
        return "admin/teacher_info/ajaxTeacherResult";
    }
}
