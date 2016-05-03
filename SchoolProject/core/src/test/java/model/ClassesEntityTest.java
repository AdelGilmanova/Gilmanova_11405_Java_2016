package model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Gilmanova.model.ClassesEntity;
import ru.kpfu.itis.Gilmanova.model.TeachersEntity;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 30.04.2016.
 */
public class ClassesEntityTest {
    private static ClassesEntity classesEntity;
    private static TeachersEntity teachersEntity;

    @BeforeClass
    public static void create() {
        teachersEntity = mock(TeachersEntity.class);
        classesEntity = new ClassesEntity("", teachersEntity);
    }


    @Test
    public void getIdShouldNotReturnNull() {
        Assert.assertNotEquals(null, classesEntity.getId());
    }

    @Test
    public void getClazzShouldNotReturnNull() {
        Assert.assertEquals("", classesEntity.getClazz());
    }

    @Test
    public void getTeachersByTeacherIdShouldNotReturnNull() {
        Assert.assertEquals(teachersEntity, classesEntity.getTeachersByTeacherId());
    }
}
