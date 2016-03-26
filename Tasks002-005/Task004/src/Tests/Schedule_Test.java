package Tests;

import Classes.Schedule;
import Classes.StudentsClass;
import Classes.Subject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 23.02.2016.
 */
public class Schedule_Test {
    private static Schedule schedule;
    private static Schedule schedule1;
    private static StudentsClass studentsClass;
    private static Subject subject;

    @BeforeClass
    public static void createSchedule() {
        subject = mock(Subject.class);
        studentsClass = mock(StudentsClass.class);
        schedule = new Schedule(studentsClass,"weekday",subject);
        schedule1 = new Schedule();
    }

    @Test
    public void constructorShouldSaveFirstParam() {
        Assert.assertEquals(subject, schedule.getSubject());
    }

    @Test
    public void constructorShouldSaveSecondParam() {
        Assert.assertEquals("weekday",schedule.getWeekday());
    }

    @Test
    public void constructorShouldSaveThirdParam() {
        Assert.assertEquals(studentsClass,schedule.getStudentsClass());
    }

    @Test
    public void zeroConstructorShouldSaveZeroParam() {
        Assert.assertEquals(null,schedule1.getStudentsClass());
        Assert.assertEquals(null,schedule1.getSubject());
        Assert.assertEquals(null,schedule1.getWeekday());
    }
}
