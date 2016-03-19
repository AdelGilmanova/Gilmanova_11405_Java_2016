package ru.kpfu.itis.java.Gilmanova.tests;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.java.Gilmanova.classes.Schedule;
import ru.kpfu.itis.java.Gilmanova.classes.StudentsClass;
import ru.kpfu.itis.java.Gilmanova.interfaces.Cookable;

import java.util.Date;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 23.02.2016.
 */
public class Cook_Test {
    private static Cookable cook;
    private static Date time;
    private static Schedule schedule;
    private static StudentsClass studentsClass;

    @BeforeClass
    public static void createCook() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        cook = (Cookable) ac.getBean("cook");
        time = mock(Date.class);
        schedule = mock(Schedule.class);
        studentsClass = mock(StudentsClass.class);
    }

    @Test
    public void cookingMethodShouldBeRight() {
        Assert.assertEquals(true, cook.cooking(time, toString(), schedule));
    }

    @Test
    public void giveOrderMethodShouldBeRight() {
        Assert.assertEquals(true, cook.giveOrder(studentsClass, time, 10));
    }

    @Test
    public void takeOrderMethodShouldBeRight() {
        Assert.assertEquals(true, cook.takeOrder(studentsClass, time, 10));
    }


}
