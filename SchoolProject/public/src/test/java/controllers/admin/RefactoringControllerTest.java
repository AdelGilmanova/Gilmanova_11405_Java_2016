package controllers.admin;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;
import ru.kpfu.itis.Gilmanova.controllers.admin.RefactoringController;
import ru.kpfu.itis.Gilmanova.service.ClassesService;
import ru.kpfu.itis.Gilmanova.service.ObjectsService;
import ru.kpfu.itis.Gilmanova.service.StudentService;
import ru.kpfu.itis.Gilmanova.service.TeacherService;

/**
 * Created by Adel on 03.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class RefactoringControllerTest {
    @InjectMocks
    private static RefactoringController refactoringController;
    @Mock
    private static StudentService studentService;
    @Mock
    private static TeacherService teacherService;
    @Mock
    private static ClassesService classesService;
    @Mock
    private static ObjectsService objectsService;
    @Mock
    private static ModelMap model;

    @Test
    public void refactorStudentGETShouldBeRight() {
        Assert.assertEquals("admin/student_info/refactor_student", refactoringController.refactorStudentGET("1", model));
    }

    @Test
    public void refactorStudentPOSTShouldBeRight() {
        Assert.assertEquals("redirect:/admin/students_list", refactoringController.refactorStudentPOST("1", "1", "1", "1"));
    }

    @Test
    public void refactorTeacherGETShouldBeRight() {
        Assert.assertEquals("admin/teacher_info/refactor_teacher", refactoringController.refactorTeacherGET("1", model));
    }

    @Test
    public void refactorTeacherPOSTShouldBeRight() {
        Assert.assertEquals("redirect:/admin/teacher_list", refactoringController.refactorTeacherPOST("1", "1", "1", "1"));
    }

    @Test
    public void addObjectShouldBeRight() {
        Assert.assertEquals("no", refactoringController.addObject("1", "1"));
    }

    @Test
    public void addClassShouldBeRight() {
        Assert.assertEquals("no", refactoringController.addClass("1", "1", "1"));
    }
}
