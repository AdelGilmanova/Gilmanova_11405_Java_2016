package ru.kpfu.itis.Gilmanova.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Admin;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Logger;
import ru.kpfu.itis.Gilmanova.controllers.BaseController;
import ru.kpfu.itis.Gilmanova.service.QuestionsService;

/**
 * Контроллер, отображающий страницу админа
 * Created by Adel on 24.04.2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
    @Autowired
    private QuestionsService questionsService;

    /*
     * Страница админа
     */
    @Logger
    @Admin
    @RequestMapping(method = RequestMethod.GET)
    public String renderAdmin() {
        return "admin/admin_cabinet";
    }

    /*
     * Список вопросов пользователей
     */
    @Logger
    @Admin
    @RequestMapping(value = "/show_questions", method = RequestMethod.GET)
    public String renderQuestions(ModelMap model) {
        model.put("questions", questionsService.getAllQuestions());
        return "admin/questions";
    }
}
