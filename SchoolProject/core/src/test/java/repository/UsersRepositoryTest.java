package repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;
import ru.kpfu.itis.Gilmanova.repository.UsersRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 30.04.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class UsersRepositoryTest {
    private static UsersRepository usersRepository;
    private static UsersEntity usersEntity;

    @BeforeClass
    public static void create() {
        SessionFactory sessionFactory = mock(SessionFactory.class);
        Criteria criteria = mock(Criteria.class);
        Session session = mock(Session.class);
        usersEntity = mock(UsersEntity.class);
        usersRepository = new UsersRepository();
        usersRepository.setSessionFactory(sessionFactory);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createCriteria(UsersEntity.class)).thenReturn(criteria);
        when(criteria.add(Restrictions.eq("", ""))).thenReturn(criteria);
        when(criteria.uniqueResult()).thenReturn(usersEntity);
    }

    @Test
    public void getUserShouldBeRight() {
        Assert.assertEquals(usersEntity, usersRepository.getUser(""));
    }
}
