package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;

/**
 * Контроллер для главной страницы
 */
@Controller
public class MainController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMainPage() {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!user.equals("anonymousUser")) {
            String role = ((MyUserDetail) user).getUserEntity().getRole();
            if (role.equals("ROLE_TEACHER")) return "redirect:/teacher";
            if (role.equals("ROLE_STUDENT")) return "redirect:/student/diary";
            if (role.equals("ROLE_ADMIN")) return "redirect:/admin";
        }
        return "main_page";
    }
}
