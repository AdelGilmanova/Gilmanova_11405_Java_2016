package ru.kpfu.itis.Gilmanova.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Admin;
import ru.kpfu.itis.Gilmanova.aspects.annotations.Logger;
import ru.kpfu.itis.Gilmanova.service.ClassesService;
import ru.kpfu.itis.Gilmanova.service.ObjectsService;
import ru.kpfu.itis.Gilmanova.service.StudentService;
import ru.kpfu.itis.Gilmanova.service.TeacherService;

/**
 * Контроллер для редактирования информации пользователей
 * Created by Adel on 26.04.2016.
 */
@Controller
@RequestMapping("/admin")
public class RefactoringController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClassesService classesService;
    @Autowired
    private ObjectsService objectsService;

    /*
     * Отображение страницы для редактирования информации об учащемся
     */
    @Logger
    @Admin
    @RequestMapping(value = "/refactor_student", method = RequestMethod.GET)
    public String refactorStudentGET(@RequestParam(required = false) String studentId,
                                     ModelMap model) {
        model.put("student", studentService.getStudent(Integer.parseInt(studentId)));
        model.put("classes", classesService.getAllClasses());
        return "admin/student_info/refactor_student";
    }

    /*
     * Редактирование информации об учащемся
     */
    @Logger
    @RequestMapping(value = "/refactor_student", method = RequestMethod.POST)
    public String refactorStudentPOST(@RequestParam(required = false) String lastName,
                                      @RequestParam(required = false) String firstName,
                                      @RequestParam(required = false) String clazz,
                                      @RequestParam(required = false) String studentId) {
        studentService.changedStudentInfo(Integer.parseInt(studentId), lastName, firstName, Integer.parseInt(clazz));
        return "redirect:/admin/students_list";
    }

    /*
     * Отображение страницы для редактирования информации об преподавателе
     */
    @Logger
    @Admin
    @RequestMapping(value = "/refactor_teacher", method = RequestMethod.GET)
    public String refactorTeacherGET(@RequestParam(required = false) String teacherId,
                                     ModelMap model) {
        model.put("teacher", teacherService.getTeacher(Integer.parseInt(teacherId)));
        model.put("teacherClasses", classesService.getClasses(Integer.parseInt(teacherId)));
        model.put("AllClasses", classesService.getAllClasses());
        model.put("teacherObjects", objectsService.getObjects(Integer.parseInt(teacherId)));
        model.put("AllObjects", objectsService.getAllObjects());
        return "admin/teacher_info/refactor_teacher";
    }

    /*
     * Редактирование информации о преподавателе
     */
    @Logger
    @RequestMapping(value = "/refactor_teacher", method = RequestMethod.POST)
    public String refactorTeacherPOST(@RequestParam(required = false) String lastName,
                                      @RequestParam(required = false) String firstName,
                                      @RequestParam(required = false) String secondName,
                                      @RequestParam(required = false) String teacherId) {
        teacherService.changeTeacherInfo(Integer.parseInt(teacherId), lastName, firstName, secondName);
        return "redirect:/admin/teacher_list";
    }

    /*
     * Добавление нового предмета, который будет преподавать препод
     */
    @Logger
    @ResponseBody
    @RequestMapping(value = "/add_object", method = RequestMethod.POST)
    public String addObject(@RequestParam String objectId,
                            @RequestParam String teacherId) {
        if (teacherService.addObject(Integer.parseInt(teacherId), Integer.parseInt(objectId))) {
            return "ok";//если добавлен
        }
        return "no";
    }

    /*
     * Добавление нового класса, в котором будет преподавать препод
     */
    @Logger
    @ResponseBody
    @RequestMapping(value = "/add_class", method = RequestMethod.POST)
    public String addClass(@RequestParam String classId,
                           @RequestParam String teacherId,
                           @RequestParam String objectId) {
        if (teacherService.addClass(
                Integer.parseInt(classId),
                Integer.parseInt(teacherId),
                Integer.parseInt(objectId))) {
            return "ok";//если добавлен
        }
        return "no";
    }
}
