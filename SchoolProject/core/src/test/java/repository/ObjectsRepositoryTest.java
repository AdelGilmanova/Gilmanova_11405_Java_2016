package repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.kpfu.itis.Gilmanova.model.ObjectsEntity;
import ru.kpfu.itis.Gilmanova.repository.ObjectsRepository;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 30.04.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class ObjectsRepositoryTest {
    private static ObjectsRepository objectsRepository;
    private static ObjectsEntity objectsEntity;
    private static List list;

    @BeforeClass
    public static void create() {
        SessionFactory sessionFactory = mock(SessionFactory.class);
        Criteria criteria = mock(Criteria.class);
        Session session = mock(Session.class);
        list = mock(List.class);
        Order order = mock(Order.class);
        objectsEntity = mock(ObjectsEntity.class);
        objectsRepository = new ObjectsRepository();
        objectsRepository.setSessionFactory(sessionFactory);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createCriteria(ObjectsEntity.class)).thenReturn(criteria);
        when(criteria.createAlias("", "")).thenReturn(criteria);
        when(criteria.add(Restrictions.eq("", ""))).thenReturn(criteria);
        when(criteria.addOrder(order)).thenReturn(criteria);
        when(criteria.list()).thenReturn(list);
        when(criteria.uniqueResult()).thenReturn(objectsEntity);
    }

    @Test
    public void getObjectShouldBeRight() {
        Assert.assertEquals(objectsEntity, objectsRepository.getObject(1));
    }

    @Test
    public void getObjectsShouldBeRight() {
        Assert.assertEquals(list, objectsRepository.getObjects(1));
    }

    @Test
    public void getAllObjectsShouldBeRight() {
        Assert.assertEquals(list, objectsRepository.getAllObjects());
    }

}
