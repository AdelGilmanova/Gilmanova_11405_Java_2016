package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Logger;
import ru.kpfu.itis.Gilmanova.service.CommentsService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
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

    @Logger
    @RequestMapping(method = RequestMethod.GET)
    public String renderComments(ModelMap model) {
        model.put("comments", commentsService.getComments());
        Cookie cookies[] = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("comment")) {
                String[] arr = cookie.getValue().split(", ");
                Integer[] comments = new Integer[arr.length];
                for (int i = 0; i < arr.length; i++) comments[i] = Integer.parseInt(arr[i]);
                List<Integer> list = Arrays.asList(comments);
                model.put("cookieComments", list);
                break;
            }
        }
        return "comments";
    }

    /*
     * Добавление нового комментария в бд
     */
    @Logger
    @RequestMapping(method = RequestMethod.POST)
    public String addComments(@RequestParam String name,
                              @RequestParam String text,
                              HttpServletResponse response) {
        Integer commentId = commentsService.addComment(name, text);

        Cookie cookies[] = request.getCookies();
        boolean pr = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("comment")) {
                Cookie c = new Cookie("comment", cookie.getValue() + ", " + commentId);
                c.setMaxAge(60 * 60);
                response.addCookie(c);
                pr = true;
                break;
            }
        }
        if (!pr) {
            Cookie c = new Cookie("comment", String.valueOf(commentId));
            c.setMaxAge(60 * 60);
            response.addCookie(c);
        }


        return "redirect:/comments";
    }

    /*
     * Удаление комментария
     */
    @Logger
    @RequestMapping(value = "/delete_comment", method = RequestMethod.POST)
    public String deleteComment(@RequestParam(required = false) String commentId) {
        commentsService.deleteComment(Integer.parseInt(commentId));
        return "redirect:/comments";
    }


}
