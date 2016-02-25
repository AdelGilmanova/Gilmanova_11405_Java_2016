package Tests;

import Classes.Subject;
import Classes.Teacher;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * Created by Adel on 23.02.2016.
 */
public class Subject_Test {
    private static Subject subject;
    private static Subject subject1;
    private static Teacher teacher;

    @BeforeClass
    public static void createSubject() {
        teacher = mock(Teacher.class);
        subject = new Subject("profile",teacher,72);
        subject1 = new Subject();
    }

    @Test
    public void constructorShouldSaveFirstParam() {
        Assert.assertEquals(teacher, subject.getTeacher());
    }

    @Test
    public void constructorShouldSaveSecondParam() {
        Assert.assertEquals(72,subject.getHours());
    }

    @Test
    public void constructorShouldSaveThirdParam() {
        Assert.assertEquals("profile",subject.getProfile());
    }

    @Test
    public void zeroConstructorShouldSaveZeroParam() {
        Assert.assertEquals(null,subject1.getTeacher());
        Assert.assertEquals(0,subject1.getHours());
        Assert.assertEquals(null,subject1.getProfile());
    }
}
