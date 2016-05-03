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
import ru.kpfu.itis.Gilmanova.controllers.MainController;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;
import ru.kpfu.itis.Gilmanova.security.MyUserDetail;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 02.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class MainControllerTest {
    @InjectMocks
    private static MainController mainController;
    @Mock
    private static MyUserDetail myUserDetail;
    @Mock
    private static UsersEntity usersEntity;

    @Test
    public void renderLoginPageShouldBeRight() {
        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(myUserDetail);
        SecurityContextHolder.setContext(securityContext);

        when(myUserDetail.getUserEntity()).thenReturn(usersEntity);
        when(usersEntity.getRole()).thenReturn("ROLE_TEACHER");
        Assert.assertEquals("redirect:/teacher", mainController.renderMainPage());
    }
}
