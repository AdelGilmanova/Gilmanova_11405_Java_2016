package ru.kpfu.itis.Gilmanova.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.Gilmanova.service.ClassesService;
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

    /*
     * Отображение страницы для редактирования информации об учащемся
     */
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
    @RequestMapping(value = "/refactor_teacher", method = RequestMethod.GET)
    public String refactorTeacherGET(@RequestParam(required = false) String teacherId,
                                     ModelMap model) {
        model.put("teacher", teacherService.getTeacher(Integer.parseInt(teacherId)));
        return "admin/teacher_info/refactor_teacher";
    }

    /*
     * Редактирование информации о преподавателе
     */
    @RequestMapping(value = "/refactor_teacher", method = RequestMethod.POST)
    public String refactorTeacherPOST(@RequestParam(required = false) String lastName,
                                      @RequestParam(required = false) String firstName,
                                      @RequestParam(required = false) String secondName,
                                      @RequestParam(required = false) String teacherId) {
        teacherService.changeTeacherInfo(Integer.parseInt(teacherId), lastName, firstName, secondName);
        return "redirect:/admin/teacher_list";
    }

}
