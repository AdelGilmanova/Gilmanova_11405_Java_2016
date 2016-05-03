package controllers.admin;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;
import ru.kpfu.itis.Gilmanova.controllers.admin.UsersController;
import ru.kpfu.itis.Gilmanova.service.ClassesService;
import ru.kpfu.itis.Gilmanova.service.StudentService;
import ru.kpfu.itis.Gilmanova.service.TeacherService;

/**
 * Created by Adel on 03.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class UsersControllerTest {
    @InjectMocks
    private static UsersController usersController;
    @Mock
    private static ClassesService classesService;
    @Mock
    private static StudentService studentService;
    @Mock
    private static TeacherService teacherService;
    @Mock
    private static ModelMap model;

    @Test
    public void renderStudentsTableShouldBeRight() {
        Assert.assertEquals("admin/student_info/students_list", usersController.renderStudentsTable(model));
    }

    @Test
    public void renderTeachersListShouldBeRight() {
        Assert.assertEquals("admin/teacher_info/teachers_list", usersController.renderTeachersList(model));
    }

    @Test
    public void searchClassShouldBeRight() {
        Assert.assertEquals("admin/student_info/ajaxStudentsResult", usersController.searchClass("1", model));
    }

    @Test
    public void searchByNameShouldBeRight() {
        Assert.assertEquals("admin/student_info/ajaxStudentsResult", usersController.searchByName("1", model));
    }

    @Test
    public void searchTeacherByNameShouldBeRight() {
        Assert.assertEquals("admin/teacher_info/ajaxTeacherResult", usersController.searchTeacherByName("1", model));
    }

}
