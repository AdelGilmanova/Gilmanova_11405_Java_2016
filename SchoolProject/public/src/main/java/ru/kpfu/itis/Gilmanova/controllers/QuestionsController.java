package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Logger;
import ru.kpfu.itis.Gilmanova.service.QuestionsService;

/**
 * Контроллер, обрабатывающий отправку вопроса пользователя
 * Created by Adel on 07.04.2016.
 */
@Controller
public class QuestionsController extends BaseController {
    @Autowired
    private QuestionsService questionsService;

    @Logger
    @RequestMapping(value = "/ask", method = RequestMethod.GET)
    public String renderAsking() {
        return "ask_question";
    }

    /*
     * Добавление вопроса в бд
     */
    @Logger
    @ResponseBody
    @RequestMapping(value = "/ask", method = RequestMethod.POST)
    public String addQuestion(@RequestParam String theme, @RequestParam String text,
                              @RequestParam String email, @RequestParam String name) {
        questionsService.addQuestions(theme, text, email, name);
        return "ok";
    }

    /*
     * Удаление вопроса
     */
    @Logger
    @RequestMapping(value = "/delete_question", method = RequestMethod.POST)
    public String deleteQuestion(@RequestParam(required = false) String questionId) {
        questionsService.deleteQuestion(Integer.parseInt(questionId));
        return "redirect:/admin/show_questions";
    }

}
