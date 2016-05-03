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
import ru.kpfu.itis.Gilmanova.controllers.HomeWorkController;
import ru.kpfu.itis.Gilmanova.model.TeachersEntity;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;
import ru.kpfu.itis.Gilmanova.service.ClassesService;
import ru.kpfu.itis.Gilmanova.service.HomeWorkService;
import ru.kpfu.itis.Gilmanova.service.ObjectsService;
import ru.kpfu.itis.Gilmanova.service.TeacherService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 02.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class HomeWorkControllerTest {
    @InjectMocks
    private static HomeWorkController homeWorkController;
    @Mock
    private static TeacherService teacherService;
    @Mock
    private static TeachersEntity teachersEntity;
    @Mock
    private static ObjectsService objectsService;
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

    @Test
    public void renderHomeWorkShouldBeRight() {
        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(myUserDetail);
        SecurityContextHolder.setContext(securityContext);
        when(myUserDetail.getUserEntity()).thenReturn(usersEntity);
        when(usersEntity.getId()).thenReturn(1);

        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("amount")).thenReturn("1");

        when(teacherService.getTeacherByUserId(anyInt())).thenReturn(teachersEntity);
        Assert.assertEquals("home_works", homeWorkController.renderHomeWork(model));
    }

    @Test
    public void addHomeWorkShouldBeRight() {
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        Assert.assertEquals("ok", homeWorkController.addHomeWork("1", "1", "1", "1"));
    }

}
