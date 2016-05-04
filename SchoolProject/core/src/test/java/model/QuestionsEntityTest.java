package model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Gilmanova.model.QuestionsEntity;

import java.sql.Date;
import java.sql.Time;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 30.04.2016.
 */
public class QuestionsEntityTest {
    private static QuestionsEntity questionsEntity;
    private static Time time;
    private static Date date;

    @BeforeClass
    public static void create() {
        time = mock(Time.class);
        date = mock(Date.class);
        questionsEntity = new QuestionsEntity("", "", "", "", time, date);
    }


    @Test
    public void getIdShouldNotReturnNull() {
        Assert.assertNotEquals(null, questionsEntity.getId());
    }

    @Test
    public void getThemeShouldNotReturnNull() {
        Assert.assertEquals("", questionsEntity.getTheme());
    }

    @Test
    public void getQuestionContentShouldNotReturnNull() {
        Assert.assertEquals("", questionsEntity.getQuestionContent());
    }

    @Test
    public void getEmailShouldNotReturnNull() {
        Assert.assertEquals("", questionsEntity.getEmail());
    }

    @Test
    public void getQuestionNameShouldNotReturnNull() {
        Assert.assertEquals("", questionsEntity.getQuestionName());
    }

    @Test
    public void getQuestionTimeShouldNotReturnNull() {
        Assert.assertEquals(time, questionsEntity.getQuestionTime());
    }

    @Test
    public void getQuestionDateShouldNotReturnNull() {
        Assert.assertEquals(date, questionsEntity.getQuestionDate());
    }


}
