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
import ru.kpfu.itis.Gilmanova.model.ClassesEntity;
import ru.kpfu.itis.Gilmanova.repository.ClassesRepository;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 30.04.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class ClassesRepositoryTest {
    private static ClassesRepository classesRepository;
    private static List list;

    @BeforeClass
    public static void create() {
        SessionFactory sessionFactory = mock(SessionFactory.class);
        Criteria criteria = mock(Criteria.class);
        Session session = mock(Session.class);
        list = mock(List.class);
        classesRepository = new ClassesRepository();
        classesRepository.setSessionFactory(sessionFactory);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createCriteria(ClassesEntity.class)).thenReturn(criteria);
        when(criteria.createAlias("", "")).thenReturn(criteria);
        when(criteria.add(Restrictions.eq("", ""))).thenReturn(criteria);
        when(criteria.list()).thenReturn(list);
    }

    @Test
    public void getAllClassesShouldBeRight() {
        Assert.assertEquals(list, classesRepository.getAllClasses());
    }

    @Test
    public void getClassesShouldBeRight() {
        Assert.assertEquals(list, classesRepository.getClasses(1));
    }


}
