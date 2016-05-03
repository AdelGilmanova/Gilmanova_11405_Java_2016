package ru.kpfu.itis.Gilmanova.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Admin;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Logger;
import ru.kpfu.itis.Gilmanova.controllers.BaseController;

/**
 * Контроллер, отображающий страницу админа
 * Created by Adel on 24.04.2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    /*
     * Страница админа
     */
    @Logger
    @Admin
    @RequestMapping(method = RequestMethod.GET)
    public String renderAdmin() {
        return "admin/admin_cabinet";
    }

}
