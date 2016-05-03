package model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Gilmanova.model.TeachersEntity;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;

import java.sql.Date;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 30.04.2016.
 */
public class TeachersEntityTest {
    private static TeachersEntity teachersEntity;
    private static UsersEntity usersEntity;
    private static Date date;

    @BeforeClass
    public static void create() {
        usersEntity = mock(UsersEntity.class);
        date = mock(Date.class);
        teachersEntity = new TeachersEntity("", "", "", "", date, "", usersEntity);
    }


    @Test
    public void getIdShouldNotReturnNull() {
        Assert.assertNotEquals(null, teachersEntity.getId());
    }

    @Test
    public void getLastNameShouldNotReturnNull() {
        Assert.assertEquals("", teachersEntity.getLastName());
    }

    @Test
    public void getFirstNameShouldNotReturnNull() {
        Assert.assertEquals("", teachersEntity.getFirstName());
    }

    @Test
    public void getSecondNameShouldNotReturnNull() {
        Assert.assertEquals("", teachersEntity.getSecondName());
    }

    @Test
    public void getGenderShouldNotReturnNull() {
        Assert.assertEquals("", teachersEntity.getGender());
    }

    @Test
    public void getPhotoShouldNotReturnNull() {
        Assert.assertEquals("", teachersEntity.getPhoto());
    }

    @Test
    public void getBirthdayShouldNotReturnNull() {
        Assert.assertEquals(date, teachersEntity.getBirthday());
    }

    @Test
    public void getTeacher_objectShouldNotReturnNull() {
        Assert.assertEquals(usersEntity, teachersEntity.getUsersEntity());
    }
}
