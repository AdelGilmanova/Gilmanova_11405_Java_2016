package Tests;

import Classes.Cook;
import Classes.Schedule;
import Classes.StudentsClass;
import Interfaces.Cookable;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

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
        cook = new Cook();
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
