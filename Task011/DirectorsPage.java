package ru.kpfu.itis.Adel_Gilmanova.controllers.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import ru.kpfu.itis.Adel_Gilmanova.patterns.ConfigSingleton;
import ru.kpfu.itis.Adel_Gilmanova.repository.TeachersRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adel on 17.10.2015.
 */
@WebServlet(name = "DirectorsPage", urlPatterns = "/director")
public class DirectorsPage extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //добавление нового студента в базу перенесено в аспект
        response.sendRedirect("/director&msg=" + request.getParameter("msg"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        Configuration cfg = ConfigSingleton.getConfig(getServletContext());
        Template tmpl = cfg.getTemplate("directors_page.ftl");

        String id = (String) request.getSession().getAttribute("id");
        Map<String, Object> root = new HashMap<>();
        root.put("form_url", request.getRequestURI());
        //проверка на авторизованность вынесена в аспект
        try {
            root.put("msg", request.getParameter("msg"));
            root.put("teacher", TeachersRepository.getTeacher(Integer.parseInt(id)));
            root.put("login", TeachersRepository.getLogin(Integer.parseInt(id)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            tmpl.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

}
