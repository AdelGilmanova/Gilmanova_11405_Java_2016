package service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.repository.QuestionsRepository;
import ru.kpfu.itis.Gilmanova.service.QuestionsService;

/**
 * Created by Adel on 30.04.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class QuestionsServiceTest {
    @InjectMocks
    private static QuestionsService questionsService;
    @Mock
    private static QuestionsRepository questionsRepository;

    @Test
    public void getAllQuestionsShouldBeRight() {
        Assert.assertEquals(questionsRepository.getAllQuestions(), questionsService.getAllQuestions());
    }

}
