package model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Gilmanova.model.ClassesEntity;
import ru.kpfu.itis.Gilmanova.model.StudentsEntity;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 30.04.2016.
 */
public class StudentsEntityTest {
    private static StudentsEntity studentsEntity;
    private static ClassesEntity classesEntity;
    private static UsersEntity usersEntity;

    @BeforeClass
    public static void create() {
        classesEntity = mock(ClassesEntity.class);
        usersEntity = mock(UsersEntity.class);
        studentsEntity = new StudentsEntity("","", classesEntity,usersEntity);
    }

    @Test
    public void getIdShouldNotReturnNull() {
        Assert.assertNotEquals(null, studentsEntity.getId());
    }

    @Test
    public void getLastNameShouldNotReturnNull() {
        Assert.assertEquals("", studentsEntity.getLastName());
    }

    @Test
    public void getFirstNameShouldNotReturnNull() {
        Assert.assertEquals("", studentsEntity.getFirstName());
    }

    @Test
    public void getClass_idShouldNotReturnNull() {
        Assert.assertEquals(classesEntity, studentsEntity.getClass_id());
    }

    @Test
    public void getUsersEntityShouldNotReturnNull() {
        Assert.assertEquals(usersEntity, studentsEntity.getUsersEntity());
    }
}
