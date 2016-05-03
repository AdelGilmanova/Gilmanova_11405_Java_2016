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
import ru.kpfu.itis.Gilmanova.model.ClassTeacherObjectEntity;
import ru.kpfu.itis.Gilmanova.model.TeacherObjectEntity;
import ru.kpfu.itis.Gilmanova.model.TeachersEntity;
import ru.kpfu.itis.Gilmanova.repository.TeacherRepository;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 30.04.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class TeacherRepositoryTest {
    private static TeacherRepository teacherRepository;
    private static TeachersEntity teachersEntity;
    private static Session session;
    private static Criteria criteria;
    private static List list;

    @BeforeClass
    public static void create() {
        SessionFactory sessionFactory = mock(SessionFactory.class);
        criteria = mock(Criteria.class);
        session = mock(Session.class);
        teachersEntity = mock(TeachersEntity.class);
        list = mock(List.class);
        Order order = mock(Order.class);
        teacherRepository = new TeacherRepository();
        teacherRepository.setSessionFactory(sessionFactory);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createCriteria(TeachersEntity.class)).thenReturn(criteria);
        when(criteria.add(Restrictions.eq("", ""))).thenReturn(criteria);
        when(criteria.uniqueResult()).thenReturn(teachersEntity);
        when(criteria.list()).thenReturn(list);
        when(criteria.addOrder(order)).thenReturn(criteria);
    }

    @Test
    public void getAllTeachersShouldBeRight() {
        Assert.assertEquals(list, teacherRepository.getAllTeachers());
    }

    @Test
    public void getTeacherByNameShouldBeRight() {
        Assert.assertEquals(list, teacherRepository.getTeacherByName(""));
    }

    @Test
    public void checkTeacher_ObjectShouldBeRight() {
        when(session.createCriteria(TeacherObjectEntity.class)).thenReturn(criteria);
        TeacherObjectEntity teacherObjectEntity = mock(TeacherObjectEntity.class);
        when(criteria.uniqueResult()).thenReturn(teacherObjectEntity);
        Assert.assertEquals(false, teacherRepository.checkTeacher_Object(1, 1));
    }

    @Test
    public void checkClass_TeacherShouldBeRight() {
        when(session.createCriteria(ClassTeacherObjectEntity.class)).thenReturn(criteria);
        TeacherObjectEntity teacherObjectEntity = mock(TeacherObjectEntity.class);
        when(criteria.uniqueResult()).thenReturn(teacherObjectEntity);
        Assert.assertEquals(false, teacherRepository.checkClass_Teacher(1, 1, 1));
    }

    @Test
    public void getTeacher_ObjectShouldBeRight() {
        when(session.createCriteria(TeacherObjectEntity.class)).thenReturn(criteria);
        TeacherObjectEntity teacherObjectEntity = mock(TeacherObjectEntity.class);
        when(criteria.uniqueResult()).thenReturn(teacherObjectEntity);
        Assert.assertEquals(teacherObjectEntity, teacherRepository.getTeacher_Object(1, 1));
    }
}
