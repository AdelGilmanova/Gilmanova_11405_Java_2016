package model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Gilmanova.model.ObjectsEntity;
import ru.kpfu.itis.Gilmanova.model.TeacherObjectEntity;
import ru.kpfu.itis.Gilmanova.model.TeachersEntity;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 30.04.2016.
 */
public class TeacherObjectEntityTest {
    private static TeacherObjectEntity teacherObjectEntity;
    private static TeachersEntity teachersEntity;
    private static ObjectsEntity objectsEntity;

    @BeforeClass
    public static void create(){
        teachersEntity = mock(TeachersEntity.class);
        objectsEntity = mock(ObjectsEntity.class);
        teacherObjectEntity = new TeacherObjectEntity(teachersEntity, objectsEntity);
    }


    @Test
    public void getIdShouldNotReturnNull(){
        Assert.assertNotEquals(null, teacherObjectEntity.getId());
    }

    @Test
         public void getObjectsEntityShouldNotReturnNull(){
        Assert.assertEquals(objectsEntity, teacherObjectEntity.getObjectsEntity());
    }

    @Test
    public void getTeachersByTeacherIdShouldNotReturnNull(){
        Assert.assertEquals(teachersEntity, teacherObjectEntity.getTeachersByTeacherId());
    }
}
