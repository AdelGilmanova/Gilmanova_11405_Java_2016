package service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.repository.CommentsRepository;
import ru.kpfu.itis.Gilmanova.service.CommentsService;

/**
 * Created by Adel on 30.04.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class CommentServiceTest {
    @InjectMocks
    private static CommentsService commentsService;
    @Mock
    private static CommentsRepository commentsRepository;

    @Test
    public void getCommentsShouldBeRight() {
        Assert.assertEquals(commentsRepository.getComments(), commentsService.getComments());
    }

}
