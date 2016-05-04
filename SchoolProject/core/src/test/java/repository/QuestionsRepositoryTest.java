package repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.model.QuestionsEntity;
import ru.kpfu.itis.Gilmanova.repository.QuestionsRepository;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 30.04.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class QuestionsRepositoryTest {
    private static QuestionsRepository questionsRepository;
    private static List list;

    @BeforeClass
    public static void create() {
        SessionFactory sessionFactory = mock(SessionFactory.class);
        Criteria criteria = mock(Criteria.class);
        Session session = mock(Session.class);
        list = mock(List.class);
        questionsRepository = new QuestionsRepository();
        questionsRepository.setSessionFactory(sessionFactory);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createCriteria(QuestionsEntity.class)).thenReturn(criteria);
        when(criteria.list()).thenReturn(list);
    }

    @Test
    public void getAllQuestionsShouldNotReturnNull() {
        Assert.assertEquals(list, questionsRepository.getAllQuestions());
    }

}
