package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;
import ru.kpfu.itis.Gilmanova.service.EstimationsService;
import ru.kpfu.itis.Gilmanova.service.StudentService;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Контроллер для отображения дневника ученика
 * Created by Adel on 09.04.2016.
 */
@Controller
@RequestMapping("/student/diary")
public class StudentController extends BaseController {
    @Autowired
    private EstimationsService estimationsService;
    @Autowired
    private StudentService studentService;

    /*
     * Показывает дневник ученика
     */
    @RequestMapping(method = RequestMethod.GET)
    public String renderDiary(@RequestParam(required = false, defaultValue = "2") String half, ModelMap model) {
        MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = user.getUserEntity().getId();
        Calendar date = new GregorianCalendar();
        model.put("table", estimationsService.getEstimationsForDiary(userId, Integer.parseInt(half),date.getWeekYear()));
        model.put("student", studentService.getStudent(userId));
        return "diary";
    }
}
