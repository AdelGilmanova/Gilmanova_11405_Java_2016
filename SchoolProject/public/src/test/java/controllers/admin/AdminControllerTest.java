package controllers.admin;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.controllers.admin.AdminController;

/**
 * Created by Adel on 03.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class AdminControllerTest {
    @InjectMocks
    private static AdminController adminController;

    @Test
    public void renderAdminShouldBeRight(){
        Assert.assertEquals("admin/admin_cabinet", adminController.renderAdmin());
    }
}
