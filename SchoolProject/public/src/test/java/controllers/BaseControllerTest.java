package controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.controllers.BaseController;

/**
 * Created by Adel on 02.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class BaseControllerTest {
    @Test
    public void redirectToMainShouldBeRight(){
        Assert.assertEquals("redirect:/", BaseController.redirectToMain());
    }
}
