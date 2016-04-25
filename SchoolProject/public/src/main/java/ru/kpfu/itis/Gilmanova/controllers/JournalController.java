package ru.kpfu.itis.Gilmanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.Gilmanova.model.ObjectsEntity;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;
import ru.kpfu.itis.Gilmanova.service.EstimationsService;
import ru.kpfu.itis.Gilmanova.service.ObjectsService;
import ru.kpfu.itis.Gilmanova.service.TeacherService;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Контроллер для отображения журнала с оценками
 * Created by Adel on 17.04.2016.
 */
@Controller
@RequestMapping("/teacher/journal")
public class JournalController extends BaseController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private EstimationsService estimationsService;
    @Autowired
    private ObjectsService objectsService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderJournal(ModelMap model) {
        //TODO проверку роли, вынести в around аспект
        MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer teacherId = user.getUserEntity().getId();
        List<ObjectsEntity> objects = objectsService.getObjects(teacherId);
        List<String> classes = estimationsService.getClasses(teacherId);
        model.put("half", 2);
        model.put("class", classes.get(0));
        model.put("classes", classes);
        model.put("teacher", teacherService.getTeacher(teacherId));
        model.put("objects", objects);
        model.put("object", objects.get(0));
        return "journal";
    }

    /*
     * Отображает журнал с оценками
     */
    @RequestMapping(value = "/show_journal", method = RequestMethod.GET)
    public String showJournal(@RequestParam(required = false) String cl,
                              @RequestParam(required = false) String half,
                              @RequestParam(required = false) String objectId,
                              ModelMap model) {
        //TODO проверку роли, вынести в around аспект
        MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer teacherId = user.getUserEntity().getId();
        List<ObjectsEntity> objects = objectsService.getObjects(teacherId);
        List<String> classes = estimationsService.getClasses(teacherId);
        Calendar date = new GregorianCalendar();
        model.put("table", estimationsService.getEstimationsForJournal(teacherId, Integer.parseInt(objectId), cl,
                Integer.parseInt(half), date.getWeekYear()));
        model.put("half", half);
        model.put("class", cl);
        model.put("classes", classes);
        model.put("teacher", teacherService.getTeacher(teacherId));
        model.put("objects", objects);
        model.put("object", objectsService.getObject(Integer.parseInt(objectId)));
        return "journal";
    }

    /*
     * Добавляет оценку в журнал
     */
    @RequestMapping(value = "/add_estimate", method = RequestMethod.POST)
    public String addEstimation(@RequestParam(required = false) String half,
                                @RequestParam(required = false) String objectId,
                                @RequestParam(required = false) String studentId,
                                @RequestParam(required = false) String estimate,
                                @RequestParam(required = false) String cl,
                                ModelMap model) {
        MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer teacherId = user.getUserEntity().getId();
        Calendar date = new GregorianCalendar();
        String[] estimates = estimate.split(",");
        for (String est : estimates) {
            if (est != null && !est.isEmpty()) {
                estimationsService.addEstimate(Integer.parseInt(est), studentId, Integer.parseInt(objectId), teacherId, Integer.parseInt(half), date.getWeekYear());
                break;
            }
        }
        return showJournal(cl, half, objectId, model);
    }
}
