package controllers.admin;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;
import ru.kpfu.itis.Gilmanova.controllers.admin.RegistrationController;
import ru.kpfu.itis.Gilmanova.service.ClassesService;
import ru.kpfu.itis.Gilmanova.service.UsersService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Adel on 03.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class RegistrationControllerTest {
    @InjectMocks
    private static RegistrationController registrationController;
    @Mock
    private static ClassesService classesService;
    @Mock
    private static UsersService usersService;
    @Mock
    private static ModelMap model;
    @Mock
    private static HttpServletRequest request;

    @Test
    public void addStudentGETShouldBeRight() {
        Assert.assertEquals("admin/student_info/add_student", registrationController.addStudentGET(model));
    }

    @Test
    public void addTeacherGETShouldBeRight(){
        Assert.assertEquals("admin/teacher_info/add_teacher", registrationController.addTeacherGET());
    }


}
