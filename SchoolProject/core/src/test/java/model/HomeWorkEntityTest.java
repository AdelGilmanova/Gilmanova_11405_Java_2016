package model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Gilmanova.model.ClassTeacherObjectEntity;
import ru.kpfu.itis.Gilmanova.model.HomeWorkEntity;

import java.sql.Date;
import java.sql.Time;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 30.04.2016.
 */
public class HomeWorkEntityTest {
    private static HomeWorkEntity homeWorkEntity;
    private static ClassTeacherObjectEntity classTeacherObjectEntity;
    private static Time time;
    private static Date date;

    @BeforeClass
    public static void create() {
        classTeacherObjectEntity = mock(ClassTeacherObjectEntity.class);
        time = mock(Time.class);
        date = mock(Date.class);
        homeWorkEntity = new HomeWorkEntity("", classTeacherObjectEntity, time, date);
    }


    @Test
    public void getIdShouldNotReturnNull() {
        Assert.assertNotEquals(null, homeWorkEntity.getId());
    }


    @Test
    public void getTimeShouldNotReturnNull() {
        Assert.assertEquals(time, homeWorkEntity.getTime());
    }

    @Test
    public void getDateShouldNotReturnNull() {
        Assert.assertEquals(date, homeWorkEntity.getDate());
    }

    @Test
    public void getHomeWorkShouldNotReturnNull() {
        Assert.assertEquals("", homeWorkEntity.getHomeWork());
    }

    @Test
    public void getClassTeacherObjectByIdShouldNotReturnNull() {
        Assert.assertEquals(classTeacherObjectEntity, homeWorkEntity.getClassTeacherObjectById());
    }

}
