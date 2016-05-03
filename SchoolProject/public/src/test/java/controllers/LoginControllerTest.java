package controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.controllers.LoginController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Adel on 02.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class LoginControllerTest {
    @InjectMocks
    private static LoginController loginController;
    @Mock
    private static HttpServletRequest request;

    @Test
    public void renderLoginPageShouldBeRight() {
        Assert.assertEquals("main_page", loginController.renderLoginPage(true));
    }
}
