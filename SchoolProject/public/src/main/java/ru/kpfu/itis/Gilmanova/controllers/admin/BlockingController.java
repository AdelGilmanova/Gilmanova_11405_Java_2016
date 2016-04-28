package ru.kpfu.itis.Gilmanova.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.Gilmanova.controllers.BaseController;
import ru.kpfu.itis.Gilmanova.service.StudentService;
import ru.kpfu.itis.Gilmanova.service.TeacherService;

/**
 * Контроллер для управления доступом пользователей
 * Created by Adel on 26.04.2016.
 */
@Controller
@RequestMapping("/admin")
public class BlockingController extends BaseController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    /*
     * Блокировка студента
     */
    @RequestMapping(value = "/blockStudent", method = RequestMethod.GET)
    public String blockStudent(@RequestParam(required = false) String studentId) {
        studentService.blockStudent(Integer.parseInt(studentId));
        return "redirect:/admin/students_list";
    }

    /*
     * Снятие блокировка студента
     */
    @RequestMapping(value = "/unblockStudent", method = RequestMethod.GET)
    public String unblockStudent(@RequestParam(required = false) String studentId) {
        studentService.unblockStudent(Integer.parseInt(studentId));
        return "redirect:/admin/students_list";
    }

    /*
     * Блокировка препода
     */
    @RequestMapping(value = "/blockTeacher", method = RequestMethod.GET)
    public String blockTeacher(@RequestParam(required = false) String teacherId) {
        teacherService.blockTeacher(Integer.parseInt(teacherId));
        return "redirect:/admin/teacher_list";
    }

    /*
     * Снятие блокировка препода
     */
    @RequestMapping(value = "/unblockTeacher", method = RequestMethod.GET)
    public String unblockTeacher(@RequestParam(required = false) String teacherId) {
        teacherService.unblockTeacher(Integer.parseInt(teacherId));
        return "redirect:/admin/teacher_list";
    }
}
