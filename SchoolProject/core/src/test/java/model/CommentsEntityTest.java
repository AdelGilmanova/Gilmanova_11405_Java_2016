package model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Gilmanova.model.CommentsEntity;

import java.sql.Date;
import java.sql.Time;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 30.04.2016.
 */
public class CommentsEntityTest {
    private static CommentsEntity commentsEntity;
    private static Time time;
    private static Date date;

    @BeforeClass
    public static void create() {
        time = mock(Time.class);
        date = mock(Date.class);
        commentsEntity = new CommentsEntity("", "", time, date);
    }


    @Test
    public void getIdShouldNotReturnNull() {
        Assert.assertNotEquals(null, commentsEntity.getId());
    }

    @Test
    public void getUserNameShouldNotReturnNull() {
        Assert.assertEquals("", commentsEntity.getUserName());
    }

    @Test
    public void getContentShouldNotReturnNull() {
        Assert.assertEquals("", commentsEntity.getContent());
    }

    @Test
    public void getTimeShouldNotReturnNull() {
        Assert.assertEquals(time, commentsEntity.getTime());
    }

    @Test
    public void getDateShouldNotReturnNull() {
        Assert.assertEquals(date, commentsEntity.getDate());
    }


}
