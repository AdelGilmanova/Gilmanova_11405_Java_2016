package ru.kpfu.itis.java.Gilmanova.tests;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.java.Gilmanova.classes.Diary;
import ru.kpfu.itis.java.Gilmanova.classes.Schedule;
import ru.kpfu.itis.java.Gilmanova.classes.Student;
import ru.kpfu.itis.java.Gilmanova.interfaces.Studentable;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 23.02.2016.
 */
public class Diary_Test {
    private static Diary diary;
    private static Diary diary1;
    private static Studentable student;
    private static ArrayList subjects;
    private static Schedule schedule;

    @BeforeClass
    public static void createDiary() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        student = mock(Student.class);
        subjects = mock(ArrayList.class);
        schedule = mock(Schedule.class);
        diary = (Diary) ac.getBean("diary");
        diary1 = (Diary) ac.getBean("emptyDiary");
    }

    @Test
    public void constructorShouldSaveFirstParam() {
        Assert.assertEquals(student,diary.getStudent());
    }

    @Test
    public void constructorShouldSaveSecondParam() {
        Assert.assertEquals(subjects,diary.getSubjectList());
    }

    @Test
    public void constructorShouldSaveThirdParam() {
        Assert.assertEquals(schedule,diary.getSchedule());
    }

    @Test
    public void zeroConstructorShouldSaveZeroParam() {
        Assert.assertEquals(null,diary1.getSchedule());
        Assert.assertEquals(null,diary1.getStudent());
        Assert.assertEquals(null,diary1.getSubjectList());
    }
}
