package controllers.admin;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;
import ru.kpfu.itis.Gilmanova.controllers.admin.AdminController;
import ru.kpfu.itis.Gilmanova.service.QuestionsService;

/**
 * Created by Adel on 03.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class AdminControllerTest {
    @InjectMocks
    private static AdminController adminController;
    @Mock
    private static QuestionsService questionsService;
    @Mock
    private static ModelMap model;

    @Test
    public void renderAdminShouldBeRight(){
        Assert.assertEquals("admin/admin_cabinet", adminController.renderAdmin());
    }

    @Test
    public void renderQuestionsShouldBeRight(){
        Assert.assertEquals("admin/questions", adminController.renderQuestions(model));
    }
}
