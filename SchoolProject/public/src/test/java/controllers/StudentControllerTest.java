package controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;
import ru.kpfu.itis.Gilmanova.controllers.StudentController;
import ru.kpfu.itis.Gilmanova.model.ClassesEntity;
import ru.kpfu.itis.Gilmanova.model.StudentsEntity;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;
import ru.kpfu.itis.Gilmanova.service.ClassesService;
import ru.kpfu.itis.Gilmanova.service.HomeWorkService;
import ru.kpfu.itis.Gilmanova.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 02.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class StudentControllerTest {
    @InjectMocks
    private static StudentController studentController;
    @Mock
    private static StudentService studentService;
    @Mock
    private static StudentsEntity studentsEntity;
    @Mock
    private static HomeWorkService homeWorkService;
    @Mock
    private static ClassesService classesService;
    @Mock
    private static ModelMap model;
    @Mock
    private static List list;
    @Mock
    private static HttpServletRequest request;
    @Mock
    private static MyUserDetail myUserDetail;
    @Mock
    private static UsersEntity usersEntity;
    @Mock
    private static ClassesEntity classesEntity;

    @Test
    public void renderStudentPageShouldBeRight() {
        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(myUserDetail);
        SecurityContextHolder.setContext(securityContext);
        when(myUserDetail.getUserEntity()).thenReturn(usersEntity);
        when(usersEntity.getId()).thenReturn(1);
        when(studentsEntity.getClass_id()).thenReturn(classesEntity);
        when(classesEntity.getId()).thenReturn(1);
        when(studentService.getStudentByUserId(anyInt())).thenReturn(studentsEntity);
        when(homeWorkService.getHomeWorksByClassId(anyInt())).thenReturn(list);
        Assert.assertEquals("student_page", studentController.renderStudentPage(model));
    }

}
