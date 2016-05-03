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
import ru.kpfu.itis.Gilmanova.model.StudentsEntity;
import ru.kpfu.itis.Gilmanova.repository.StudentRepository;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Adel on 30.04.2016.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class StudentRepositoryTest {
    private static StudentRepository studentRepository;
    private static StudentsEntity studentsEntity;
    private static List list;

    @BeforeClass
    public static void create() {
        SessionFactory sessionFactory = mock(SessionFactory.class);
        Criteria criteria = mock(Criteria.class);
        Session session = mock(Session.class);
        studentsEntity = mock(StudentsEntity.class);
        list = mock(List.class);
        Order order = mock(Order.class);
        studentRepository = new StudentRepository();
        studentRepository.setSessionFactory(sessionFactory);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createCriteria(StudentsEntity.class)).thenReturn(criteria);
        when(criteria.add(Restrictions.eq("", ""))).thenReturn(criteria);
        when(criteria.uniqueResult()).thenReturn(studentsEntity);
        when(criteria.list()).thenReturn(list);
        when(criteria.addOrder(order)).thenReturn(criteria);
    }

    @Test
    public void getStudentByUserIdShouldBeRight() {
        Assert.assertEquals(studentsEntity, studentRepository.getStudentByUserId(1));
    }

    @Test
    public void getStudentShouldBeRight() {
        Assert.assertEquals(studentsEntity, studentRepository.getStudent(1));
    }

    @Test
    public void getAllStudentsShouldBeRight() {
        Assert.assertEquals(list, studentRepository.getAllStudents());
    }

    @Test
    public void getStudentByClassShouldBeRight() {
        Assert.assertEquals(list, studentRepository.getStudentByClass(1));
    }

    @Test
    public void getStudentByNameShouldBeRight() {
        Assert.assertEquals(list, studentRepository.getStudentByName(""));
    }
}
