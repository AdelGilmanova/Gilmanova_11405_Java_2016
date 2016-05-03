package model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Gilmanova.model.*;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 30.04.2016.
 */
public class ClassTeacherObjectEntityTest {
    private static ClassTeacherObjectEntity classTeacherObjectEntity;
    private static ClassesEntity classesEntity;
    private static TeacherObjectEntity teacherObjectEntity;


    @BeforeClass
    public static void create(){
        classesEntity = new ClassesEntity();
        teacherObjectEntity = mock(TeacherObjectEntity.class);
        classTeacherObjectEntity = new ClassTeacherObjectEntity(classesEntity, teacherObjectEntity);
    }


    @Test
    public void getIdShouldNotReturnNull(){
        Assert.assertNotEquals(null, classTeacherObjectEntity.getId());
    }


    @Test
    public void getClass_idShouldNotReturnNull(){
        Assert.assertEquals(classesEntity, classTeacherObjectEntity.getClass_id());
    }

    @Test
    public void getTeacher_object_idShouldNotReturnNull(){
        Assert.assertEquals(teacherObjectEntity, classTeacherObjectEntity.getTeacher_object_id());
    }

}
