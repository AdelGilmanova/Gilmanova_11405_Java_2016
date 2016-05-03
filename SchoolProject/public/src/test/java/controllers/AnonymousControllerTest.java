package controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.controllers.AnonymousController;

/**
 * Created by Adel on 02.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class AnonymousControllerTest {
    @InjectMocks
    private static AnonymousController anonymousController;

    @Test
    public void renderInformationShouldBeRight() {
        Assert.assertEquals("information", anonymousController.renderInformation());
    }

    @Test
    public void renderForParentsShouldBeRight() {
        Assert.assertEquals("for_parents", anonymousController.renderForParents());
    }
}
