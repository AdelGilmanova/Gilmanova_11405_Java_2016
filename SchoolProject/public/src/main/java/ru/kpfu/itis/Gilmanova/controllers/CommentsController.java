package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.Gilmanova.service.CommentsService;

/**
 * Контроллер, обрабатывающий комментарии пользователей
 * Created by Adel on 09.04.2016.
 */
@Controller
@RequestMapping("/comments")
public class CommentsController extends BaseController{
    @Autowired
    private CommentsService commentsService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderComments(ModelMap model){
        model.put("comments", commentsService.getComments());
        return "comments";
    }

    /*
     * Добавление нового комментария в бд
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addComments(@RequestParam String name, @RequestParam String text){
        commentsService.addComment(name, text);
        return "redirect:/comments";
    }

    /*
     * Удаление комментария
     */
    @RequestMapping(value = "/delete_comment", method = RequestMethod.POST)
    public String deleteComment(@RequestParam(required = false) String commentId){
        commentsService.deleteComment(Integer.parseInt(commentId));
        return "redirect:/comments";
    }


}
