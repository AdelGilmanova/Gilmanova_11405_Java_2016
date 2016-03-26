package ru.kpfu.itis.java.Gilmanova.tests;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.java.Gilmanova.classes.Schedule;
import ru.kpfu.itis.java.Gilmanova.classes.StudentsClass;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 23.02.2016.
 */
public class Schedule_Test {
    private static Schedule schedule;
    private static Schedule schedule1;
    private static StudentsClass studentsClass;
    private static ArrayList subject;

    @BeforeClass
    public static void createSchedule() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        subject = mock(ArrayList.class);
        studentsClass = mock(StudentsClass.class);
        schedule = (Schedule) ac.getBean("schedule");
        schedule1 = (Schedule) ac.getBean("emptySchedule");;
    }

    @Test
    public void constructorShouldSaveFirstParam() {
        Assert.assertEquals(subject, schedule.getSubjectList());
    }

    @Test
    public void constructorShouldSaveSecondParam() {
        Assert.assertEquals("monday",schedule.getWeekday());
    }

    @Test
    public void constructorShouldSaveThirdParam() {
        Assert.assertEquals(studentsClass,schedule.getStudentsClass());
    }

    @Test
    public void zeroConstructorShouldSaveZeroParam() {
        Assert.assertEquals(null,schedule1.getStudentsClass());
        Assert.assertEquals(null,schedule1.getSubjectList());
        Assert.assertEquals(null,schedule1.getWeekday());
    }
}
