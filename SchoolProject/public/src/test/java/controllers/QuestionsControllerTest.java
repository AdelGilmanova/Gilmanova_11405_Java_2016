package controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.controllers.QuestionsController;
import ru.kpfu.itis.Gilmanova.service.QuestionsService;

/**
 * Created by Adel on 02.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class QuestionsControllerTest {
    @InjectMocks
    private static QuestionsController questionsController;
    @Mock
    private static QuestionsService questionsService;

    @Test
    public void addQuestionShouldBeRight() {
        Assert.assertEquals("ok", questionsController.addQuestion("", "", "", ""));
    }

    @Test
    public void deleteQuestionShouldBeRight() {
        Assert.assertEquals("redirect:/admin/show_questions", questionsController.deleteQuestion("1"));
    }
}
