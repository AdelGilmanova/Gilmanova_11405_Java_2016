package ru.kpfu.itis.java.Gilmanova.tests;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.java.Gilmanova.classes.Student;
import ru.kpfu.itis.java.Gilmanova.classes.Subject;
import ru.kpfu.itis.java.Gilmanova.interfaces.Journalable;
import ru.kpfu.itis.java.Gilmanova.interfaces.Studentable;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 23.02.2016.
 */
public class Casebook_Test {
    private static Journalable casebook;
    private static Subject subject;
    private static Studentable student;

    @BeforeClass
    public static void createCasebook() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        casebook = (Journalable) ac.getBean("casebook");
        subject = mock(Subject.class);
        student = mock(Student.class);
    }

    @Test
    public void deleteDataMethodShouldBeRight() {
        Assert.assertEquals(true, casebook.deleteData(3, subject, (Student) student));
    }

    @Test
    public void saveDataMethodShouldBeRight() {
        Assert.assertEquals(true, casebook.saveData(3, subject, (Student) student));
    }

    @Test
    public void showDataMethodShouldBeRight() {
        Assert.assertEquals(true, casebook.showData(3, subject, (Student) student));
    }
}
