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
public class Student_Test {
    private static Studentable student;
    private static Subject subject;
    private static Date date;
    private static Teacher teacher;
    private static StudentsClass studentsClass;
    private static Diary diary;

    @BeforeClass
    public static void createStudent() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        student = (Studentable) ac.getBean("student");
        subject = mock(Subject.class);
        date = mock(Date.class);
        teacher = mock(Teacher.class);
        studentsClass = mock(StudentsClass.class);
        diary = mock(Diary.class);
    }

    @Test
    public void doClassWorkMethodShouldBeRight() {
        Assert.assertEquals(true, student.doClassWork(subject, date, 4));
    }

    @Test
    public void setEstimateMethodShouldBeRight() {
        Assert.assertEquals(true, student.setEstimate(5, teacher, diary));
    }

    @Test
    public void goToLessonsMethodShouldBeRight() {
        Assert.assertEquals(true, student.goToLessons(subject, date, studentsClass));
    }
}
