package ru.kpfu.itis.java.Gilmanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Adel on 18.03.2016.
 */
@Controller
public class MainController {
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/process", method = RequestMethod.GET)
    public String processGET(){
        return "process";
    }

    @RequestMapping(value="/process", method = RequestMethod.POST)
    public String processPOST(ModelMap model, @RequestParam String text, @RequestParam String value){

        HttpSession session = request.getSession();
        if (value.equals("symbols")) {
            session.setAttribute("result", text.length() + " ");
        }
        if (value.equals("words")) {
            String[] arr = text.split(" ");
            session.setAttribute("result", String.valueOf(arr.length));
        }
        if (value.equals("sentences")) {
            String[] arr = text.split(". ");
            session.setAttribute("result", String.valueOf(arr.length));
        }
        if (value.equals("paragraphs")) {
            String[] arr = text.split("\n");
            model.put("result", String.valueOf(arr.length));
        }
        return "result";
    }

    @RequestMapping(value="/result", method = RequestMethod.GET)
    public String resultMethod(){
        return "result";
    }
}
