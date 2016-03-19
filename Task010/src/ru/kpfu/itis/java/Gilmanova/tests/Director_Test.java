package ru.kpfu.itis.java.Gilmanova.tests;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.java.Gilmanova.classes.*;
import ru.kpfu.itis.java.Gilmanova.interfaces.Studentable;

import java.util.Date;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 23.02.2016.
 */
public class Director_Test {
    private static Director director;
    private static Teacher teacher;
    private static Studentable student;
    private static Subject subject;
    private static StudentsClass studentsClass;
    private static Date date;

    @BeforeClass
    public static void createDirector() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        director = (Director) ac.getBean("director");
        teacher = mock(Teacher.class);
        student = mock(Student.class);
        subject = mock(Subject.class);
        studentsClass = mock(StudentsClass.class);
        date = mock(Date.class);
    }

    @Test
    public void changeWagesMethodShouldBeRight() {
        Assert.assertEquals(true, director.changeWages(teacher, 50000));
    }

    @Test
    public void dismissMethodShouldBeRight() {
        Assert.assertEquals(true, director.dismiss(teacher, toString()));
    }

    @Test
    public void expelMethodShouldBeRight() {
        Assert.assertEquals(true, director.expel((Student) student, subject, 3));
    }

    @Test
    public void pullEstimateMethodShouldBeRight() {
        Assert.assertEquals(true, director.pullEstimate(5, subject, (Student) student));
    }

    @Test
    public void spendLineMethodShouldBeRight() {
        Assert.assertEquals(true, director.spendLine(studentsClass, date, 100));
    }

    @Test
    public void teachMethodShouldBeRight() {
        Assert.assertEquals(true, director.teach(subject, studentsClass, 72));
    }
}
