package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Logger;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Teacher;
import ru.kpfu.itis.Gilmanova.model.TeachersEntity;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;
import ru.kpfu.itis.Gilmanova.service.ClassesService;
import ru.kpfu.itis.Gilmanova.service.HomeWorkService;
import ru.kpfu.itis.Gilmanova.service.ObjectsService;
import ru.kpfu.itis.Gilmanova.service.TeacherService;

import javax.servlet.http.HttpSession;

/**
 * Контроллер для добавление новых домашек преподавателем
 * Created by Adel on 17.04.2016.
 */
@Controller
@RequestMapping("/teacher/add_home_work")
public class HomeWorkController extends BaseController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ObjectsService objectsService;
    @Autowired
    private ClassesService classesService;
    @Autowired
    private HomeWorkService homeWorkService;

    @Logger
    @Teacher
    @RequestMapping(method = RequestMethod.GET)
    public String renderHomeWork(ModelMap model) {
        MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = user.getUserEntity().getId();
        TeachersEntity teachersEntity = teacherService.getTeacherByUserId(userId);
        model.put("classes", classesService.getClasses(teachersEntity.getId()));
        model.put("teacher", teacherService.getTeacher(teachersEntity.getId()));
        model.put("objects", objectsService.getObjects(teachersEntity.getId()));
        model.put("home_work", request.getSession().getAttribute("amount"));
//        Cookie cookies[] = request.getCookies();
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals("home_work")) {
//                model.put("home_work", cookie.getValue());
//                break;
//            }
//        }
        return "home_works";
    }

    @Logger
    @Teacher
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public String addHomeWork(@RequestParam(required = false) String classId,
                              @RequestParam(required = false) String objectId,
                              @RequestParam(required = false) String teacherId,
                              @RequestParam(required = false) String home_work) {
        homeWorkService.addHomeWork(Integer.parseInt(classId),
                Integer.parseInt(objectId),
                Integer.parseInt(teacherId),
                home_work);
        HttpSession session = request.getSession();
        Integer amount = (Integer) session.getAttribute("amount");
        if (amount != null) session.setAttribute("amount", amount + 1);
        else session.setAttribute("amount", 1);

//        Cookie cookies[] = request.getCookies();
//        boolean pr = false;
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals("home_work")) {
//                Integer value = Integer.parseInt(cookie.getValue());
//                value += 1;
//                Cookie c = new Cookie("home_work", String.valueOf(value));
//                c.setMaxAge(60 * 60 * 5);
//                response.addCookie(c);
//                pr = true;
//                break;
//            }
//        }
//        if (!pr) {
//            Cookie cookie = new Cookie("home_work", String.valueOf(1));
//            cookie.setMaxAge(60 * 60 * 5);
//            response.addCookie(cookie);
//        }
        return "ok";
    }
}
