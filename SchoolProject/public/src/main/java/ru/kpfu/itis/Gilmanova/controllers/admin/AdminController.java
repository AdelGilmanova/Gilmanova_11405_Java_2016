package ru.kpfu.itis.Gilmanova.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.Gilmanova.controllers.BaseController;
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
    public String renderQuestions(ModelMap model) {
        model.put("questions", questionsService.getAllQuestions());
        return "admin/questions";
    }
}
