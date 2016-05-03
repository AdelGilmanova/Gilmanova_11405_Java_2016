package controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;
import ru.kpfu.itis.Gilmanova.controllers.CommentsController;
import ru.kpfu.itis.Gilmanova.service.CommentsService;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 02.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class CommentsControllerTest {
    @InjectMocks
    private static CommentsController commentsController;
    @Mock
    private static CommentsService commentsService;

    @Test
    public void renderCommentsShouldBeRight(){
        ModelMap model = mock(ModelMap.class);
        Assert.assertEquals("comments", commentsController.renderComments(model));
    }

    @Test
    public void addCommentsShouldBeRight(){
        Assert.assertEquals("redirect:/comments", commentsController.addComments("", ""));
    }

    @Test
    public void deleteCommentShouldBeRight(){
        Assert.assertEquals("redirect:/comments", commentsController.deleteComment("1"));
    }
}
