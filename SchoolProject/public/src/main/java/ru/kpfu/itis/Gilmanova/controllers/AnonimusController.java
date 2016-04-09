package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Контроллер, отображающий общую информацию о школе
 * Created by Adel on 07.04.2016.
 */
@Controller
public class AnonimusController extends BaseController {

    @RequestMapping(value = "/information",method = RequestMethod.GET)
    public String renderInformation() {
        return "information";
    }

    @RequestMapping(value = "/for_parents",method = RequestMethod.GET)
    public String renderForParents() {
        return "for_parents";
    }
}
