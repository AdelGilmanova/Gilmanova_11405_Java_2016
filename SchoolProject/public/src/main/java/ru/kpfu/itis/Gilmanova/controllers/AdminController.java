package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.Gilmanova.service.ClassesService;
import ru.kpfu.itis.Gilmanova.service.QuestionsService;
import ru.kpfu.itis.Gilmanova.service.StudentService;
import ru.kpfu.itis.Gilmanova.service.TeacherService;

/**
 * Контроллер отображающий страницу админа
 * Created by Adel on 24.04.2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClassesService classesService;

    /*
     * Страница админа
     */
    @RequestMapping(method = RequestMethod.GET)
    public String renderAdmin() {
        return "admin/admin_cabinet";
    }

    /*
     * Список вопросов пользователей
     */
    @RequestMapping(value = "/show_questions", method = RequestMethod.GET)
    public String renderQuestions(ModelMap model){
        model.put("questions", questionsService.getAllQuestions());
        return "admin/questions";
    }

    /*
     * Таблица с учащимися
     */
    @RequestMapping(value = "/students_list", method=RequestMethod.GET)
    public String renderStudentsTable(ModelMap model){
        model.put("students", studentService.getAllStudents());
        model.put("classes", classesService.getAllClasses());
        return "admin/students_list";
    }

    /*
     * Таблица с преподавателями
     */
    @RequestMapping(value = "/teacher_list", method=RequestMethod.GET)
    public String renderTeachersList(ModelMap model){
        model.put("teachers", teacherService.getAllTeachers());
        return "admin/teachers_list";
    }

    /*
     * Возвращает учащихся с нужного класса AJAX
     */
    @RequestMapping(value="/searchClass",method=RequestMethod.GET)
    public String searchClass(@RequestParam(required = false) String classId,
                              ModelMap model){
        model.put("students", studentService.getStudentByClass(Integer.parseInt(classId)));
        return "admin/ajaxStudentsResult";
    }

    /*
     * Возвращает учащихся с нужным именем AJAX
     */
    @RequestMapping(value="/searchByName",method=RequestMethod.GET)
    public String searchByName(@RequestParam(required = false) String name,
                              ModelMap model){
        model.put("students", studentService.getStudentByName(name));
        return "admin/ajaxStudentsResult";
    }
}
