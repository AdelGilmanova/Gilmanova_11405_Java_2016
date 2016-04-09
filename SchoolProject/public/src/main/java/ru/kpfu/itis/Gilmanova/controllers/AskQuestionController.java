package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.Gilmanova.service.QuestionsService;

/**
 * Контроллер, обрабатывающий отправку вопроса пользователя
 * Created by Adel on 07.04.2016.
 */
@Controller
@RequestMapping(value = "/ask")
public class AskQuestionController extends BaseController{
    @Autowired
    private QuestionsService questionsService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderAsking() {
        return "ask_question";
    }

    /*
     * Добавление вопроса в бд
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public String sendAsk(@RequestParam String theme, @RequestParam String text,
                          @RequestParam String email, @RequestParam String name) {
        questionsService.addQuestions(theme, text, email, name);
        return "ok";
    }

}
