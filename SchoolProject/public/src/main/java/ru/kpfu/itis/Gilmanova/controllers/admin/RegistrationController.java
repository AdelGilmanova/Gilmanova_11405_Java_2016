package ru.kpfu.itis.Gilmanova.controllers.admin;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Admin;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Logger;
import ru.kpfu.itis.Gilmanova.controllers.BaseController;
import ru.kpfu.itis.Gilmanova.form.StudentRegistrationFormBean;
import ru.kpfu.itis.Gilmanova.form.TeacherRegistrationFormBean;
import ru.kpfu.itis.Gilmanova.service.ClassesService;
import ru.kpfu.itis.Gilmanova.service.StudentService;
import ru.kpfu.itis.Gilmanova.service.UsersService;

import javax.validation.Valid;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

/**
 * Контроллер для регистрации новых пользователей
 * Created by Adel on 26.04.2016.
 */
@Controller
@RequestMapping("/admin")
public class RegistrationController extends BaseController {
    public static final String STUDENT_FORM = "studentForm";
    public static final String TEACHER_FORM = "teacherForm";
    @Autowired
    private ClassesService classesService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private StudentService studentService;

    /*
     * Отображение формы по добавлению нового учащегося
     */
    @Logger
    @Admin
    @RequestMapping(value = "/add_student", method = RequestMethod.GET)
    public String addStudentGET(ModelMap model) {
        request.setAttribute(STUDENT_FORM, new StudentRegistrationFormBean());
        model.put("classes", classesService.getAllClasses());
        return "admin/student_info/add_student";
    }

    /*
     * Добавление нового учащегося
     */
    @Logger
    @RequestMapping(value = "/add_student", method = RequestMethod.POST)
    public String addStudentPOST(@Valid @ModelAttribute(STUDENT_FORM) StudentRegistrationFormBean regFormBean,
                                 BindingResult bindingResult)
            throws NoSuchAlgorithmException, IOException {
        if (bindingResult.hasErrors()) {
            return "admin/student_info/add_student";
        }
        String hash_pass = DigestUtils.md5Hex(regFormBean.getPassword1()); //хэширование
        usersService.addUser(regFormBean.getLastName(), regFormBean.getFirstName(), Integer.parseInt(regFormBean.getClazz()),
                regFormBean.getLogin(), hash_pass);
        System.out.println(regFormBean);
        return "redirect:/admin/students_list";
    }

    /*
     * Отображение формы по добавлению нового преподавателя
     */
    @Logger
    @Admin
    @RequestMapping(value = "/add_teacher", method = RequestMethod.GET)
    public String addTeacherGET() {
        request.setAttribute(TEACHER_FORM, new TeacherRegistrationFormBean());
        return "admin/teacher_info/add_teacher";
    }

    /*
     * Добавление нового препода
     */
    @Logger
    @RequestMapping(value = "/add_teacher", method = RequestMethod.POST)
    public String addTeacherPOST(@Valid @ModelAttribute(TEACHER_FORM) TeacherRegistrationFormBean regFormBean,
                                 BindingResult bindingResult)
            throws NoSuchAlgorithmException, IOException {
        if (bindingResult.hasErrors()) {
            return "admin/teacher_info/add_teacher";
        }
        String birthDay = regFormBean.getYear() + "-" +
                regFormBean.getMonth() + "-" + regFormBean.getDay();
        Date date = Date.valueOf(birthDay);
        String hash_pass = DigestUtils.md5Hex(regFormBean.getPassword1()); //хэширование
        usersService.addUser(
                regFormBean.getLastName(),
                regFormBean.getFirstName(),
                regFormBean.getSecondName(),
                date,
                regFormBean.getGender(),
                regFormBean.getLogin(), hash_pass);
        System.out.println(regFormBean);
        return "redirect:/admin/teacher_list";
    }

}
