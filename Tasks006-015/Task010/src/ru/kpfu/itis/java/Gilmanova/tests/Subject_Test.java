package ru.kpfu.itis.java.Gilmanova.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.java.Gilmanova.classes.Subject;
import ru.kpfu.itis.java.Gilmanova.classes.Teacher;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 23.02.2016.
 */
public class Subject_Test {
    private static Subject subject;
    private static Subject subject1;
    private static Teacher teacher;

    @BeforeClass
    public static void createSubject() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        teacher = mock(Teacher.class);
        subject = (Subject) ac.getBean("history");
        subject1 = (Subject) ac.getBean("emptySubject");
    }

    @Test
    public void constructorShouldSaveFirstParam() {
        Assert.assertEquals(teacher, subject.getTeacher());
    }

    @Test
    public void constructorShouldSaveSecondParam() {
        Assert.assertEquals(72, subject.getHours());
    }

    @Test
    public void constructorShouldSaveThirdParam() {
        Assert.assertEquals("history", subject.getProfile());
    }

    @Test
    public void zeroConstructorShouldSaveZeroParam() {
        Assert.assertEquals(null, subject1.getTeacher());
        Assert.assertEquals(0, subject1.getHours());
        Assert.assertEquals(null, subject1.getProfile());
    }
}
