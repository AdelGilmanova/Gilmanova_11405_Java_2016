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
import ru.kpfu.itis.Gilmanova.controllers.TeacherController;
import ru.kpfu.itis.Gilmanova.model.TeachersEntity;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;
import ru.kpfu.itis.Gilmanova.service.TeacherService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 02.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class TeacherControllerTest {
    @InjectMocks
    private static TeacherController teacherController;
    @Mock
    private static TeacherService teacherService;
    @Mock
    private static TeachersEntity teachersEntity;
    @Mock
    private static ModelMap model;
    @Mock
    private static MyUserDetail myUserDetail;
    @Mock
    private static UsersEntity usersEntity;

    @Test
    public void renderTeacherShouldBeRight() {
        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(myUserDetail);
        SecurityContextHolder.setContext(securityContext);
        when(myUserDetail.getUserEntity()).thenReturn(usersEntity);
        when(usersEntity.getId()).thenReturn(1);

        Assert.assertEquals("teachers_page", teacherController.renderTeacher(model));
    }

}
