package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.Gilmanova.model.CommentsEntity;
import ru.kpfu.itis.Gilmanova.service.CommentsService;

import javax.validation.Valid;
import java.util.List;

/**
 * Контроллер, обрабатывающий комментарии пользователей
 * Created by Adel on 09.04.2016.
 */
@Controller
@RequestMapping("/comments")
public class CommentsController extends BaseController {
    @Autowired
    private CommentsService commentsService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CommentsEntity> renderComments() {
        return commentsService.getComments();
    }

    /*
     * Добавление нового комментария в бд
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Integer addComments(@Valid @RequestBody CommentsEntity commentsEntity) {
        return commentsService.addComment(commentsEntity.getUserName(), commentsEntity.getContent());
    }

    /*
     * Удаление комментария
     */
    @RequestMapping(value = "/delete_comment", method = RequestMethod.POST)
    public String deleteComment(@RequestParam(required = false) String commentId) {
        commentsService.deleteComment(Integer.parseInt(commentId));
        return "redirect:/comments";
    }


}
