package ru.kpfu.itis.java.Gilmanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Adel on 18.03.2016.
 */
@Controller
public class MainController {
    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "/getDate", method = RequestMethod.GET)
    public String getDate(ModelMap model) {
        model.put("date", new Date());
        return "date";
    }

    @RequestMapping(value = "/search/*", method = RequestMethod.GET)
    public String searchMethod(ModelMap model) {
        String path = request.getRequestURI();

        String sitePattern = "baidu.com|bing.com|yahoo.com|aol.com";
        Pattern p = Pattern.compile(sitePattern);
        String[] sitePath = path.split("/");
        Matcher m = p.matcher(sitePath[2]);
        if (m.matches()) {
            String site = m.group();
            model.put("action", "#");

            if (site.equals("baidu.com")) {
                model.put("name", "baidu.com");
                model.put("action", "http://www.baidu.com/s");
                model.put("parameter", "wd");
            }
            if (site.equals("bing.com")) {
                model.put("name", "bing.com");
                model.put("action", "http://www.bing.com/search");
                model.put("parameter", "q");
            }
            if (site.equals("yahoo.com")) {
                model.put("name", "yahoo.com");
                model.put("action", "https://search.yahoo.com/search");
                model.put("parameter", "p");
            }
            if (site.equals("aol.com")) {
                model.put("name", "aol.com");
                model.put("action", "http://search.aol.com/aol/search");
                model.put("parameter", "q");
            }
            return "search";
        } else {
            return "redirect:/error404";
        }

    }

    @RequestMapping(value = "/add/**", method = RequestMethod.GET)
    public String additionMethod(ModelMap model) {
        String uri = request.getRequestURI();
        String[] path = uri.split("/");
        if (Pattern.matches("(-)?[0-9]+", path[2]) && Pattern.matches("(-)?[0-9]+", path[3])) {
            int a = Integer.parseInt(path[2]);
            int b = Integer.parseInt(path[3]);
            String operation;
            if (b < 0) operation = "";
            else operation = "+";
            model.put("msg", a + operation + b + "=" + (a + b));
        } else {
            model.put("msg", "Wrong format of numbers");
        }
        return "operation_result";
    }

    @RequestMapping(value = "/mult/**", method = RequestMethod.GET)
    public String multiplicationMethod(ModelMap model) {
        String uri = request.getRequestURI();
        String[] path = uri.split("/");
        if (Pattern.matches("(-)?[0-9]+", path[2]) && Pattern.matches("(-)?[0-9]+", path[3])) {
            int a = Integer.parseInt(path[2]);
            int b = Integer.parseInt(path[3]);
            model.put("msg", a + "*" + b + "=" + (a * b));
        } else {
            model.put("msg", "Wrong format of numbers");
        }
        return "operation_result";
    }

    @RequestMapping(value = "/error404", method = RequestMethod.GET)
    public String error404Method() {
        return "error404";
    }

}
